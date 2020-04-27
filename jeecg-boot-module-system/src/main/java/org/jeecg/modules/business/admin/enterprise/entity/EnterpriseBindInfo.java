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
 * @Description: 企业绑定信息
 * @Author: jeecg-boot
 * @Date: 2020-04-24
 * @Version: V1.0
 */
@Data
@TableName("enterprise_bind_info")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "enterprise_bind_info对象", description = "企业绑定信息")
public class EnterpriseBindInfo {

    /**
     * ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "ID")
    private java.lang.String id;
    /**
     * 企业ID
     */
    @Excel(name = "企业ID", width = 15)
    @ApiModelProperty(value = "企业ID")
    private java.lang.String enterpriseId;
    /**
     * 企业绑定信息 10/手机号 20/邮箱
     */
    @Excel(name = "企业绑定信息 10/手机号 20/邮箱", width = 15)
    @ApiModelProperty(value = "企业绑定信息 10/手机号 20/邮箱")
    private java.lang.String bindType;
    /**
     * 绑定内容
     */
    @Excel(name = "绑定内容", width = 15)
    @ApiModelProperty(value = "绑定内容")
    private java.lang.String bindValue;
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
