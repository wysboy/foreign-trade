package org.jeecg.modules.business.admin.enterprise.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.jeecgframework.poi.excel.annotation.Excel;
@Data
@ToString
public class AddEnterpriseAuthInfoModel {

    /**
     * 企业编码
     */
    @Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private java.lang.String enterpriseId;
    /**
     * 企业认证名称
     */
    @Excel(name = "企业认证名称", width = 15)
    @ApiModelProperty(value = "企业认证名称")
    private java.lang.String authName;
    /**
     * 企业信用编码
     */
    @Excel(name = "企业信用编码", width = 15)
    @ApiModelProperty(value = "企业信用编码")
    private java.lang.String authCode;
}
