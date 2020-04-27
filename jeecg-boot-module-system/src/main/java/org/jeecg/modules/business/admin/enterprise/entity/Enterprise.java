package org.jeecg.modules.business.admin.enterprise.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date: 2020-04-24
 * @Version: V1.0
 */
@Data
@TableName("enterprise")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "enterprise对象", description = "企业表")
public class Enterprise {

    /**
     * 企业ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "企业ID")
    private java.lang.String id;
    /**
     * 企业名称
     */
    @Excel(name = "企业名称", width = 15)
    @ApiModelProperty(value = "企业名称")
    private java.lang.String enterpriseName;
    /**
     * 企业类型 10/外贸企业，20/服务商
     */
    @Excel(name = "企业类型 10/外贸企业，20/服务商", width = 15)
    @ApiModelProperty(value = "企业类型 10/外贸企业，20/服务商")
    private java.lang.String enterpriseType;
    /**
     * 企业规模 10/一般纳税人，20/小规模纳税人
     */
    @Excel(name = "企业规模 10/一般纳税人，20/小规模纳税人", width = 15)
    @ApiModelProperty(value = "企业规模 10/一般纳税人，20/小规模纳税人")
    private java.lang.String enterpriseScale;
    /**
     * 省
     */
    @Excel(name = "省", width = 15)
    @ApiModelProperty(value = "省")
    private java.lang.Integer province;
    /**
     * 市
     */
    @Excel(name = "市", width = 15)
    @ApiModelProperty(value = "市")
    private java.lang.Integer city;
    /**
     * 区
     */
    @Excel(name = "区", width = 15)
    @ApiModelProperty(value = "区")
    private java.lang.Integer area;
    /**
     * 街道地址
     */
    @Excel(name = "街道地址", width = 15)
    @ApiModelProperty(value = "街道地址")
    private java.lang.String address;
    /**
     * 联系人
     */
    @Excel(name = "联系人", width = 15)
    @ApiModelProperty(value = "联系人")
    private java.lang.String contacts;
    /**
     * 联系人电话
     */
    @Excel(name = "联系人电话", width = 15)
    @ApiModelProperty(value = "联系人电话")
    private java.lang.String contactsMobile;
    /**
     * 企业状态 10/未合作，20/合作中，30/合作过期
     */
    @Excel(name = "企业状态 10/未合作，20/合作中，30/合作过期", width = 15)
    @ApiModelProperty(value = "企业状态 10/未合作，20/合作中，30/合作过期")
    private java.lang.String enterpriseStatus;
    /**
     * 创建人
     */
    @Excel(name = "创建人", width = 15)
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
    /**
     * 修改人
     */
    @Excel(name = "修改人", width = 15)
    @ApiModelProperty(value = "修改人")
    private java.lang.String updateBy;
    /**
     * 修改时间
     */
    @Excel(name = "修改时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date updateTime;
    /**
     * 删除标识0-正常,1-已删除
     */
    @Excel(name = "删除标识0-正常,1-已删除", width = 15)
    @ApiModelProperty(value = "删除标识0-正常,1-已删除")
    private java.lang.Integer delFlag;
}
