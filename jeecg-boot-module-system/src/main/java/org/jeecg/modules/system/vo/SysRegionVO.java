package org.jeecg.modules.system.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SysRegionVO {

    @ApiModelProperty(value = "城市id")
    private Integer value;

    @ApiModelProperty(value = "城市名称")
    private String label;

    @ApiModelProperty(value = "子城市id")
    private Integer pid;

    @ApiModelProperty(value = "子城市")
    private List<SysRegionVO> children;

}
