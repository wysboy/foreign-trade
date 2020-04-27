package org.jeecg.modules.business.admin.enterprise.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddEnterpriseBindInfoModel {

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
