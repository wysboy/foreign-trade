package org.jeecg.modules.business.admin.enterprise.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.modules.business.admin.enterprise.model.QueryEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.vo.EnterpriseVO;
import org.jeecg.modules.business.admin.enterprise.vo.PageBean;
import org.jeecg.modules.business.admin.enterprise.entity.Enterprise;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseModel;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.controller.JeecgController;

import org.jeecg.modules.business.emums.EnterpriseStatus;
import org.jeecg.modules.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date: 2020-04-24
 * @Version: V1.0
 */
@Slf4j
@Api(tags = "企业表")
@RestController
@RequestMapping("/business/enterprise")
public class EnterpriseController extends JeecgController<Enterprise, IEnterpriseService> {
    @Autowired
    private IEnterpriseService enterpriseService;

    /**
     * 分页列表查询
     *
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @AutoLog(value = "企业表-分页列表查询")
    @ApiOperation(value = "企业表-分页列表查询", notes = "企业表-分页列表查询")
    @GetMapping(value = "/list")
    public Result<PageBean<EnterpriseVO>> queryPageList(QueryEnterpriseModel model,
                                                        @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                        HttpServletRequest req) {

        IPage<EnterpriseVO> pageList = enterpriseService.getEnterpriseList(pageNo,pageSize,model);

        //返回的分页信息
        PageBean<EnterpriseVO> pageBean = new PageBean<>();
        pageBean.setData(pageList.getRecords());
        pageBean.setPageNo(pageNo);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(pageList.getTotal());
        pageBean.setTotalPage(pageList.getPages());

        //返回结果
        Result<PageBean<EnterpriseVO>> result = new Result<>();
        result.setResult(pageBean);
        result.setSuccess(true);

        return result;
    }

    /**
     * 添加
     *
     * @param model
     * @return
     */
    @AutoLog(value = "企业表-添加")
    @ApiOperation(value = "企业表-添加", notes = "企业表-添加")
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody AddEnterpriseModel model) {
        return enterpriseService.enterpriseAdd(model);
    }

    /**
     * 编辑
     *
     * @param model
     * @return
     */
    @AutoLog(value = "企业表-编辑")
    @ApiOperation(value = "企业表-编辑", notes = "企业表-编辑")
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody UpdateEnterpriseModel model) {
        return enterpriseService.updateEnterprise(model);
    }

    /**
     * 企业审核
     *
     * @param id
     * @return
     */
    @AutoLog(value = "企业审核")
    @ApiOperation(value = "企业审核", notes = "企业审核")
    @GetMapping(value = "/auditEnterprise/{id}")
    public Result<?> auditEnterprise(@PathVariable("id") String id) {
        return enterpriseService.auditEnterprise(id);
    }


    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "企业表-通过id删除")
    @ApiOperation(value = "企业表-通过id删除", notes = "企业表-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        enterpriseService.removeById(id);
        return Result.ok("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "企业表-批量删除")
    @ApiOperation(value = "企业表-批量删除", notes = "企业表-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.enterpriseService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.ok("批量删除成功！");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @AutoLog(value = "企业表-通过id查询")
    @ApiOperation(value = "企业表-通过id查询", notes = "企业表-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<?> queryById(@RequestParam(name = "id", required = true) String id) {
        return enterpriseService.getByEnterpriseId(id);
    }



}
