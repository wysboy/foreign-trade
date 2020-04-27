package org.jeecg.modules.business.admin.enterprise.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.business.admin.enterprise.entity.Enterprise;
import org.jeecg.modules.business.admin.enterprise.mapper.EnterpriseMapper;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;

/**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
@Slf4j
@Service
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements IEnterpriseService {

    @Override
    public Result enterpriseAdd(AddEnterpriseModel model) {

        LoginUser loginUser = ((LoginUser) SecurityUtils.getSubject().getPrincipal());
        Enterprise enterprise = new Enterprise();

        BeanUtils.copyProperties(model, enterprise);
        this.enterprise(enterprise,loginUser);

        if(!this.save(enterprise)){
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

    private void enterprise(Enterprise enterprise,LoginUser loginUser) {
        enterprise.setCreateTime(new Date());
        enterprise.setCreateBy(loginUser.getUsername());
        enterprise.setUpdateBy(loginUser.getUsername());
        enterprise.setUpdateTime(new Date());
    }
}
