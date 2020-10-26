package org.jeecg.modules.business.admin.enterprise.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 企业认证信息
 */
@Data
public class EnterpriseBindInfoVO {

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private java.lang.String id;
    /**
     * 企业ID
     */
    @ApiModelProperty(value = "企业ID")
    private java.lang.String enterpriseId;
    /**
     * 企业绑定信息 10/手机号 20/邮箱
     */
    @ApiModelProperty(value = "企业绑定信息 10/手机号 20/邮箱")
    private java.lang.String bindType;
    /**
     * 绑定内容
     */
    @ApiModelProperty(value = "绑定内容")
    private java.lang.String bindValue;

}
