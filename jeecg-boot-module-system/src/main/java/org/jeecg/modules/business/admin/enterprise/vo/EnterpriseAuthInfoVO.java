package org.jeecg.modules.business.admin.enterprise.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 企业认证信息
 */
@Data
public class EnterpriseAuthInfoVO {

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
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
    @Excel(name = "企业信用编码", width = 15)
    @ApiModelProperty(value = "企业信用编码")
    private java.lang.String authCode;

}
