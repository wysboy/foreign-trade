package org.jeecg.modules.business.admin.enterprise.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.business.admin.enterprise.entity.Enterprise;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseBindInfo;
import org.jeecg.modules.business.admin.enterprise.mapper.EnterpriseMapper;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.model.QueryEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseBindInfoService;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseService;
import org.jeecg.modules.business.admin.enterprise.vo.EnterpriseVO;
import org.jeecg.modules.business.emums.EnterpriseStatus;
import org.jeecg.modules.system.controller.LoginController;
import org.jeecg.modules.system.service.ISysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;

/**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date: 2020-04-24
 * @Version: V1.0
 */
@Slf4j
@Service
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements IEnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private ISysUserService userService;

    @Autowired
    @Lazy
    private IEnterpriseBindInfoService enterpriseBindInfoServiceImpl;

    @Override
    public Result enterpriseAdd(AddEnterpriseModel model) {

        LoginUser loginUser = ((LoginUser) SecurityUtils.getSubject().getPrincipal());
        Enterprise enterprise = new Enterprise();

        BeanUtils.copyProperties(model, enterprise);
        this.enterprise(enterprise, loginUser);

        if (!this.save(enterprise)) {
            throw new RuntimeException("添加企业用户信息失败");
        }

        return Result.ok("添加企业用户信息成功");
    }

    @Override
    public Result<?> updateEnterprise(UpdateEnterpriseModel model) {
        LoginUser loginUser = ((LoginUser) SecurityUtils.getSubject().getPrincipal());
        Enterprise enterprise = new Enterprise();
        BeanUtils.copyProperties(model, enterprise);
        this.enterprise(enterprise, loginUser);

        if (!updateById(enterprise)) {
            log.error("修改企业信息异常,updateEnterpriseModel={},taxEnterprise={}", model, enterprise);
            throw new RuntimeException("修改企业信息异常");
        }

        return Result.ok("修改企业用户信息成功");
    }

    @Override
    public Result<?> auditEnterprise(String id) {
        Enterprise enterprise = this.getById(id);
        if (enterprise == null) {
            throw new RuntimeException("企业异常");
        }

        if (!EnterpriseStatus.wait_audit.getId().equals(enterprise.getEnterpriseStatus())) {
            throw new RuntimeException("企业状态异常!");
        }

        EnterpriseBindInfo bindInfo = new EnterpriseBindInfo();
        bindInfo.setEnterpriseId(id);
        QueryWrapper<EnterpriseBindInfo> bindInfoQueryWrapper = new QueryWrapper<>(bindInfo);
        EnterpriseBindInfo _bindInfo = enterpriseBindInfoServiceImpl.getOne(bindInfoQueryWrapper);
        // 效验是否填写企业绑定信息
        if(null == _bindInfo || StringUtils.isEmpty(_bindInfo.getBindValue())){
            log.error("绑定信息企业,获取企业绑定信息异常,_bindInfo={}", _bindInfo);
            throw new RuntimeException("请填写企业绑定信息!");
        }

        String bindValue = _bindInfo.getBindValue();

        //修改企业状态
        Enterprise _enterprise = new Enterprise();
        _enterprise.setId(id);
        _enterprise.setEnterpriseStatus(EnterpriseStatus.normal.getId());
        if (!this.updateById(_enterprise)) {
            log.error("审核企业,修改企业状态异常,enterprise={}", _enterprise);
            throw new RuntimeException("修改企业状态异常");
        }

        //生成登录信息
        String loginPassword = RandomUtil.randomString(LoginController.BASE_CHECK_CODES, 12);
        Result loginUserResult = userService.createUserLogin(id, bindValue, loginPassword, enterprise.getEnterpriseName());
        if (!loginUserResult.isSuccess()) {
            throw new RuntimeException("创建登录信息失败");
        }

        return Result.ok("审核成功!");
    }

    @Override
    public IPage<EnterpriseVO> getEnterpriseList(Integer pageNo, Integer pageSize, QueryEnterpriseModel model) {
        Page<EnterpriseVO> page = new Page<>(pageNo, pageSize);
        page = enterpriseMapper.getEnterpriseList(page, model);
        return page;
    }

    @Override
    public Result<?> getByEnterpriseId(String id) {
        EnterpriseVO  rs = enterpriseMapper.getByEnterpriseId(id);
        return Result.ok(rs);
    }

    private void enterprise(Enterprise enterprise, LoginUser loginUser) {
        enterprise.setCreateTime(new Date());
        enterprise.setCreateBy(loginUser.getUsername());
        enterprise.setUpdateBy(loginUser.getUsername());
        enterprise.setUpdateTime(new Date());
    }
}
