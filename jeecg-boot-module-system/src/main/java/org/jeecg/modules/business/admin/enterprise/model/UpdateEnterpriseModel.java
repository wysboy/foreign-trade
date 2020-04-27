package org.jeecg.modules.business.admin.enterprise.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateEnterpriseModel {

    /**
     * 企业编号
     */
    @ApiModelProperty(value = "企业ID")
    private java.lang.String id;
    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private java.lang.String enterpriseName;
    /**
     * 企业类型 10/外贸企业，20/服务商
     */
    @ApiModelProperty(value = "企业类型 10/外贸企业，20/服务商")
    private java.lang.String enterpriseType;
    /**
     * 企业规模 10/一般纳税人，20/小规模纳税人
     */
    @ApiModelProperty(value = "企业规模 10/一般纳税人，20/小规模纳税人")
    private java.lang.String enterpriseScale;
    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private java.lang.Integer province;
    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private java.lang.Integer city;
    /**
     * 区
     */
    @ApiModelProperty(value = "区")
    private java.lang.Integer area;
    /**
     * 街道地址
     */
    @ApiModelProperty(value = "街道地址")
    private java.lang.String address;
    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private java.lang.String contacts;
    /**
     * 联系人电话
     */
    @ApiModelProperty(value = "联系人电话")
    private java.lang.String contactsMobile;
    /**
     * 企业状态 10/未合作，20/合作中，30/合作过期
     */
    @ApiModelProperty(value = "企业状态 10/未合作，20/合作中，30/合作过期")
    private java.lang.String enterpriseStatus;


}
