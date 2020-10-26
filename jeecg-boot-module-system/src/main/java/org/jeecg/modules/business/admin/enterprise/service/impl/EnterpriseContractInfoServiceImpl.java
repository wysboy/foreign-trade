package org.jeecg.modules.business.admin.enterprise.service.impl;

import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.business.admin.enterprise.entity.Enterprise;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseContractInfo;
import org.jeecg.modules.business.admin.enterprise.mapper.EnterpriseContractInfoMapper;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseContractInfoModel;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseContractInfoService;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;

/**
 * @Description: 企业合同信息
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Service
public class EnterpriseContractInfoServiceImpl extends ServiceImpl<EnterpriseContractInfoMapper, EnterpriseContractInfo> implements IEnterpriseContractInfoService {

    @Autowired
    private IEnterpriseService enterpriseService;

    @Override
    public Result<?> addEnterpriseContract(AddEnterpriseContractInfoModel model) {
        LoginUser loginUser = ((LoginUser) SecurityUtils.getSubject().getPrincipal());

        String enterpriseId = model.getEnterpriseId();
        Enterprise enterprise = enterpriseService.getById(enterpriseId);
        if(enterprise==null){
            return Result.error("企业异常");
        }

        EnterpriseContractInfo enterpriseContractInfo = new EnterpriseContractInfo();
        BeanUtils.copyProperties(model, enterpriseContractInfo);
        this.EnterpriseContract(enterpriseContractInfo,loginUser);

        if(!this.save(enterpriseContractInfo)){
            throw new RuntimeException("添加企业合同信息失败");
        }

        return Result.ok("添加企业合同信息成功");
    }


    private void EnterpriseContract(EnterpriseContractInfo enterpriseContractInfo, LoginUser loginUser) {
        enterpriseContractInfo.setCreateTime(new Date());
        enterpriseContractInfo.setCreateBy(loginUser.getUsername());
        enterpriseContractInfo.setUpdateBy(loginUser.getUsername());
        enterpriseContractInfo.setUpdateTime(new Date());
    }
}
