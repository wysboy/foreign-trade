package org.jeecg.modules.business.admin.enterprise.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.business.admin.enterprise.entity.Enterprise;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.model.QueryEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.vo.EnterpriseVO;

/**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
public interface IEnterpriseService extends IService<Enterprise> {

    /**
     * 新增企业
     * @param model
     * @return
     */
    Result enterpriseAdd(AddEnterpriseModel model);

    /**
     * 修改企业
     * @param model
     * @return
     */
    Result<?> updateEnterprise(UpdateEnterpriseModel model);

    /**
     * 审核企业
      * @param id
     * @return
     */
    Result<?> auditEnterprise(String id);

    /**
     * 企业列表
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     */
    IPage<EnterpriseVO> getEnterpriseList(Integer pageNo, Integer pageSize, QueryEnterpriseModel model);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Result<?> getByEnterpriseId(String id);
}
