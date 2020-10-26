package org.jeecg.modules.business.admin.enterprise.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.business.admin.enterprise.entity.Enterprise;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.business.admin.enterprise.model.QueryEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.vo.EnterpriseVO;

/**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
public interface EnterpriseMapper extends BaseMapper<Enterprise> {

    Page<EnterpriseVO> getEnterpriseList(Page<EnterpriseVO> page, QueryEnterpriseModel model);

    EnterpriseVO getByEnterpriseId(@Param("id") String id);
}
