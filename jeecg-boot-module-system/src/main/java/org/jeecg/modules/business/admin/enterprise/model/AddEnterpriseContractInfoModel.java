package org.jeecg.modules.business.admin.enterprise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ToString
public class AddEnterpriseContractInfoModel {

    /**企业编码*/
    @Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private java.lang.String enterpriseId;
    /**合同编码*/
    @Excel(name = "合同编码", width = 15)
    @ApiModelProperty(value = "合同编码")
    private java.lang.String contractNo;
    /**合同类型1/企业签约合同*/
    @Excel(name = "合同类型1/企业签约合同", width = 15)
    @ApiModelProperty(value = "合同类型1/企业签约合同")
    private java.lang.String contractType;
    /**合同名称*/
    @Excel(name = "合同名称", width = 15)
    @ApiModelProperty(value = "合同名称")
    private java.lang.String contractName;
    /**合同开始时间*/
    @Excel(name = "合同开始时间", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "合同开始时间")
    private java.util.Date contractBeginDate;
    /**合同结束日期*/
    @Excel(name = "合同结束日期", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "合同结束日期")
    private java.util.Date contractEndDate;
    /**合同地址*/
    @Excel(name = "合同地址", width = 15)
    @ApiModelProperty(value = "合同地址")
    private java.lang.String contractUrl;

}
