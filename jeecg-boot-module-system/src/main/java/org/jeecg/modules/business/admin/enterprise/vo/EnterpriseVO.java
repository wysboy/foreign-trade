package org.jeecg.modules.business.admin.enterprise.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;
@Data
public class EnterpriseVO {

    /**
     * 企业ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
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
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private java.lang.String updateBy;
    /**
     * 修改时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date updateTime;
    /**
     * 删除标识0-正常,1-已删除
     */
    @ApiModelProperty(value = "删除标识0-正常,1-已删除")
    private java.lang.Integer delFlag;

    @ApiModelProperty(value = "详细地址 省/市/区/街道")
    private java.lang.String detailedAddress;

}
