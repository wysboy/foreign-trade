package org.jeecg.modules.system.entity;

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
 * @Description: 城市
 * @Author: jeecg-boot
 * @Date:   2020-05-12
 * @Version: V1.0
 */
@Data
@TableName("sys_region")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="sys_region对象", description="城市")
public class SysRegion {
    
	/**id*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
	private Integer id;
	/**name*/
	@Excel(name = "name", width = 15)
    @ApiModelProperty(value = "name")
	private String name;
	/**fullname*/
	@Excel(name = "fullname", width = 15)
    @ApiModelProperty(value = "fullname")
	private String fullname;
	/**pinyin*/
	@Excel(name = "pinyin", width = 15)
    @ApiModelProperty(value = "pinyin")
	private String pinyin;
	/**lat*/
	@Excel(name = "lat", width = 15)
    @ApiModelProperty(value = "lat")
	private String lat;
	/**lng*/
	@Excel(name = "lng", width = 15)
    @ApiModelProperty(value = "lng")
	private String lng;
	/**pid*/
	@Excel(name = "pid", width = 15)
    @ApiModelProperty(value = "pid")
	private Integer pid;
	/**level*/
	@Excel(name = "level", width = 15)
    @ApiModelProperty(value = "level")
	private Integer level;
	/**首字母*/
	@Excel(name = "首字母", width = 15)
    @ApiModelProperty(value = "首字母")
	private String szm;
	/**createdAt*/
	@Excel(name = "createdAt", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "createdAt")
	private Date createdAt;
	/**updatedAt*/
    @ApiModelProperty(value = "updatedAt")
	private Date updatedAt;
}
