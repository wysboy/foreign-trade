package org.jeecg.modules.business.admin.enterprise.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 企业合同信息
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Data
@TableName("enterprise_contract_info")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="enterprise_contract_info对象", description="企业合同信息")
public class EnterpriseContractInfo {
    
	/**ID*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "ID")
	private java.lang.String id;
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
	/**创建人*/
	@Excel(name = "创建人", width = 15)
    @ApiModelProperty(value = "创建人")
	private java.lang.String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
	private java.util.Date createTime;
	/**修改人*/
	@Excel(name = "修改人", width = 15)
    @ApiModelProperty(value = "修改人")
	private java.lang.String updateBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
	private java.util.Date updateTime;
	/**删除标识0-正常,1-已删除*/
	@Excel(name = "删除标识0-正常,1-已删除", width = 15)
    @ApiModelProperty(value = "删除标识0-正常,1-已删除")
	private java.lang.Integer delFlag;
}
