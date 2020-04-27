package org.jeecg.modules.business.admin.enterprise.service;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.business.admin.enterprise.VO.EnterpriseAuthInfoVO;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseAuthInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseAuthInfoModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseAuthInfoModel;

/**
 * @Description: 企业认证信息
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
public interface IEnterpriseAuthInfoService extends IService<EnterpriseAuthInfo> {

    /**
     * 通过enterpriseId查询查询
     * @param enterpriseId
     * @return
     */
    Result<EnterpriseAuthInfoVO> queryByEnterpriseId(String enterpriseId);

    Result<?> addEnterpriseAuthInfo(AddEnterpriseAuthInfoModel model);

    Result<?> updateEnterpriseAuthInfo(UpdateEnterpriseAuthInfoModel model);
}
