package org.jeecg.modules.business.admin.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.business.admin.enterprise.VO.EnterpriseAuthInfoVO;
import org.jeecg.modules.business.admin.enterprise.entity.Enterprise;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseAuthInfo;
import org.jeecg.modules.business.admin.enterprise.mapper.EnterpriseAuthInfoMapper;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseAuthInfoModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseAuthInfoModel;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseAuthInfoService;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;

/**
 * @Description: 企业认证信息
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
@Slf4j
@Service
public class EnterpriseAuthInfoServiceImpl extends ServiceImpl<EnterpriseAuthInfoMapper, EnterpriseAuthInfo> implements IEnterpriseAuthInfoService {

    @Autowired
    private IEnterpriseService enterpriseService;

    @Override
    public Result<EnterpriseAuthInfoVO> queryByEnterpriseId(String enterpriseId) {
        Enterprise enterprise = enterpriseService.getById(enterpriseId);

        if(enterprise==null){
            throw new RuntimeException("企业异常");
        }

        EnterpriseAuthInfo enterpriseAuthInfo =new EnterpriseAuthInfo();
        enterpriseAuthInfo.setEnterpriseId(enterpriseId);
        QueryWrapper<EnterpriseAuthInfo> wrapper = new QueryWrapper(enterpriseAuthInfo);
        EnterpriseAuthInfo authInfo = this.getOne(wrapper);

        EnterpriseAuthInfoVO enterpriseAuthInfoVO = new EnterpriseAuthInfoVO();
        BeanUtils.copyProperties(authInfo, enterpriseAuthInfoVO);

        Result<EnterpriseAuthInfoVO> result = new Result<>();
        result.setResult(enterpriseAuthInfoVO);
        return result;
    }

    @Override
    public Result<?> addEnterpriseAuthInfo(AddEnterpriseAuthInfoModel model) {

        LoginUser loginUser = ((LoginUser) SecurityUtils.getSubject().getPrincipal());

        String enterpriseId = model.getEnterpriseId();
        Enterprise enterprise = enterpriseService.getById(enterpriseId);
        if(enterprise==null){
            return Result.error("企业异常");
        }

        EnterpriseAuthInfo enterpriseAuthInfo = new EnterpriseAuthInfo();
        enterpriseAuthInfo.setEnterpriseId(enterpriseId);
        enterpriseAuthInfo.setAuthCode(model.getAuthCode());
        enterpriseAuthInfo.setAuthName(model.getAuthName());
        enterpriseAuthInfo.setCreateBy(loginUser.getUsername());
        enterpriseAuthInfo.setCreateTime(new Date());
        enterpriseAuthInfo.setUpdateBy(loginUser.getUsername());
        enterpriseAuthInfo.setUpdateTime(new Date());

        if(!this.save(enterpriseAuthInfo)){
            log.error("新增企业认证信息异常,AddEnterpriseAuthInfoModel={}", model.toString());
            throw new RuntimeException("新增企业认证信息异常");
        }

        return Result.ok("提交成功!");
    }

    @Override
    public Result<?> updateEnterpriseAuthInfo(UpdateEnterpriseAuthInfoModel model) {
        LoginUser loginUser = ((LoginUser) SecurityUtils.getSubject().getPrincipal());

        String enterpriseId = model.getEnterpriseId();
        Enterprise enterprise = enterpriseService.getById(enterpriseId);
        if(enterprise==null){
            return Result.error("企业异常");
        }

        EnterpriseAuthInfo enterpriseAuthInfo = new EnterpriseAuthInfo();
        enterpriseAuthInfo.setAuthCode(model.getAuthCode());
        enterpriseAuthInfo.setAuthName(model.getAuthName());
        enterpriseAuthInfo.setUpdateBy(loginUser.getUsername());
        enterpriseAuthInfo.setUpdateTime(new Date());

        if(!this.updateById(enterpriseAuthInfo)){
            log.error("修改企业认证信息异常,AddEnterpriseAuthInfoModel={}", model.toString());
            throw new RuntimeException("修改企业认证信息异常");
        }

        return Result.ok("提交成功!");
    }
}
