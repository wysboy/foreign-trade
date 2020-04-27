package org.jeecg.modules.business.admin.enterprise.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class UpdateEnterpriseAuthInfoModel {
    /**
     * 企业认证信息编码
     */
    @ApiModelProperty(value = "企业认证信息编码")
    private java.lang.String id;

    /**
     * 企业编码
     */
    @ApiModelProperty(value = "企业编码")
    private java.lang.String enterpriseId;
    /**
     * 企业认证名称
     */
    @ApiModelProperty(value = "企业认证名称")
    private java.lang.String authName;
    /**
     * 企业信用编码
     */
    @ApiModelProperty(value = "企业信用编码")
    private java.lang.String authCode;

}
