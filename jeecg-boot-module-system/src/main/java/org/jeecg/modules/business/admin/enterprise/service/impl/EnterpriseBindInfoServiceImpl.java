package org.jeecg.modules.business.admin.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.business.admin.enterprise.VO.EnterpriseBindInfoVO;
import org.jeecg.modules.business.admin.enterprise.entity.Enterprise;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseBindInfo;
import org.jeecg.modules.business.admin.enterprise.mapper.EnterpriseBindInfoMapper;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseBindInfoModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseBindInfoModel;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseBindInfoService;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description: 企业绑定信息
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
@Slf4j
@Service
public class EnterpriseBindInfoServiceImpl extends ServiceImpl<EnterpriseBindInfoMapper, EnterpriseBindInfo> implements IEnterpriseBindInfoService {

    @Autowired
    private IEnterpriseService enterpriseService;


    @Override
    public Result<?> queryByEnterpriseId(String enterpriseId) {
        Enterprise enterprise = enterpriseService.getById(enterpriseId);

        if(enterprise==null){
            throw new RuntimeException("企业异常");
        }

        EnterpriseBindInfo enterpriseBindInfo =new EnterpriseBindInfo();
        enterpriseBindInfo.setEnterpriseId(enterpriseId);
        QueryWrapper<EnterpriseBindInfo> wrapper = new QueryWrapper(enterpriseBindInfo);
        EnterpriseBindInfo bindInfo = this.getOne(wrapper);

        EnterpriseBindInfoVO enterpriseBindInfoVO = new EnterpriseBindInfoVO();
        BeanUtils.copyProperties(bindInfo, enterpriseBindInfoVO);

        Result<EnterpriseBindInfoVO> result = new Result<>();
        result.setResult(enterpriseBindInfoVO);
        return result;
    }

    @Override
    public Result<?> addEnterpriseBindInfo(AddEnterpriseBindInfoModel model) {
        LoginUser loginUser = ((LoginUser) SecurityUtils.getSubject().getPrincipal());

        String enterpriseId = model.getEnterpriseId();
        Enterprise enterprise = enterpriseService.getById(enterpriseId);
        if(enterprise==null){
            return Result.error("企业异常");
        }

        EnterpriseBindInfo enterpriseBindInfo = new EnterpriseBindInfo();
        enterpriseBindInfo.setEnterpriseId(enterpriseId);
        enterpriseBindInfo.setBindType(model.getBindType());
        enterpriseBindInfo.setBindValue(model.getBindValue());
        enterpriseBindInfo.setCreateBy(loginUser.getUsername());
        enterpriseBindInfo.setCreateTime(new Date());
        enterpriseBindInfo.setUpdateBy(loginUser.getUsername());
        enterpriseBindInfo.setUpdateTime(new Date());

        if(!this.save(enterpriseBindInfo)){
            log.error("新增企业绑定信息异常,AddEnterpriseBindInfoModel={}", model.toString());
            throw new RuntimeException("新增企业绑定信息异常");
        }

        return Result.ok("提交成功!");
    }

    @Override
    public Result<?> updateEnterpriseBindInfo(UpdateEnterpriseBindInfoModel model) {

        LoginUser loginUser = ((LoginUser) SecurityUtils.getSubject().getPrincipal());

        String enterpriseId = model.getEnterpriseId();
        Enterprise enterprise = enterpriseService.getById(enterpriseId);
        if(enterprise==null){
            return Result.error("企业异常");
        }

        EnterpriseBindInfo enterpriseBindInfo = new EnterpriseBindInfo();
        enterpriseBindInfo.setBindType(model.getBindType());
        enterpriseBindInfo.setBindValue(model.getBindValue());
        enterpriseBindInfo.setUpdateBy(loginUser.getUsername());
        enterpriseBindInfo.setUpdateTime(new Date());

        if(!this.updateById(enterpriseBindInfo)){
            log.error("修改企业绑定信息异常,UpdateEnterpriseBindInfoModel={}", model.toString());
            throw new RuntimeException("修改企业绑定信息异常");
        }

        return Result.ok("提交成功!");
    }


}
