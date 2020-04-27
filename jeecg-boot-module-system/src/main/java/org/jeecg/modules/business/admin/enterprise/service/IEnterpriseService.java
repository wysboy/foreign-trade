package org.jeecg.modules.business.admin.enterprise.service;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.business.admin.enterprise.entity.Enterprise;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseModel;

/**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
public interface IEnterpriseService extends IService<Enterprise> {

    Result enterpriseAdd(AddEnterpriseModel model);

    Result<?> updateEnterprise(UpdateEnterpriseModel model);
}
