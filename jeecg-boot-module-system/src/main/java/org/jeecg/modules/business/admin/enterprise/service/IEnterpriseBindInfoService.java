package org.jeecg.modules.business.admin.enterprise.service;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseBindInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseBindInfoModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseBindInfoModel;

/**
 * @Description: 企业绑定信息
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
public interface IEnterpriseBindInfoService extends IService<EnterpriseBindInfo> {
    /**
     * 通过enterpriseId查询
     * @param enterpriseId
     * @return
     */
    Result<?> queryByEnterpriseId(String enterpriseId);

    /**
     * 新增企业绑定信息
     * @param model
     * @return
     */
    Result<?> addEnterpriseBindInfo(AddEnterpriseBindInfoModel model);

    /**
     *  修改企业绑定信息
     * @param model
     * @return
     */
    Result<?> updateEnterpriseBindInfo(UpdateEnterpriseBindInfoModel model);
}
