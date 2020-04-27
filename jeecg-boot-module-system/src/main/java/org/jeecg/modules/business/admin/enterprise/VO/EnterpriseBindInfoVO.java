package org.jeecg.modules.business.admin.enterprise.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 企业认证信息
 */
@Data
public class EnterpriseBindInfoVO {

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private java.lang.String id;
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
