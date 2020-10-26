package org.jeecg.modules.business.admin.enterprise.service;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseContractInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseContractInfoModel;

/**
 * @Description: 企业合同信息
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
public interface IEnterpriseContractInfoService extends IService<EnterpriseContractInfo> {
    /**
     * 添加企业合同
     * @param model
     * @return
     */
    Result<?> addEnterpriseContract(AddEnterpriseContractInfoModel model);
}
