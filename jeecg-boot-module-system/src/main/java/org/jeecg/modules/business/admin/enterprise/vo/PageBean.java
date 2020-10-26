package org.jeecg.modules.business.admin.enterprise.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Title: Page
 * @Description: 分页信息返回
 * @Author <a href="mailto:chenxb1993@126.com">陈晓博</a>
 * @Date 2018-06-08 15:47
 * @Version V1.0
 */
@Data
public class PageBean<T> {

    @ApiModelProperty(value = "页码")
    private Integer pageNo;

    @ApiModelProperty(value = "每页条数")
    private Integer pageSize;

    @ApiModelProperty(value = "总页数")
    private Long totalPage;

    @ApiModelProperty(value = "总条数")
    private Long totalCount;

    @ApiModelProperty(value = "数据列表")
    private List<T> data;

}
