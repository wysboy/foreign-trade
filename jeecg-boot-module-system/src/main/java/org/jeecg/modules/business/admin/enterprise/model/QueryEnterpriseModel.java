package org.jeecg.modules.business.admin.enterprise.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryEnterpriseModel {

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;
    @ApiModelProperty(value = "企业状态")
    private String enterpriseStatus;

}
