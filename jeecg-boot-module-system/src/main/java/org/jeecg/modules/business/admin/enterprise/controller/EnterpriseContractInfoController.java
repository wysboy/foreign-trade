package org.jeecg.modules.business.admin.enterprise.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.modules.business.admin.enterprise.vo.PageBean;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseContractInfo;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseContractInfoModel;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseContractInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.business.emums.EnterpriseContractType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 企业合同信息
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Slf4j
@Api(tags="企业合同信息")
@RestController
@RequestMapping("/business.admin.enterprise/enterpriseContractInfo")
public class EnterpriseContractInfoController extends JeecgController<EnterpriseContractInfo, IEnterpriseContractInfoService> {
	@Autowired
	private IEnterpriseContractInfoService enterpriseContractInfoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param enterpriseContractInfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "企业合同信息-分页列表查询")
	@ApiOperation(value="企业合同信息-分页列表查询", notes="企业合同信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(EnterpriseContractInfo enterpriseContractInfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<EnterpriseContractInfo> queryWrapper = QueryGenerator.initQueryWrapper(enterpriseContractInfo, req.getParameterMap());

		//查询状态为下面两种类型
		if (StringUtils.isEmpty(enterpriseContractInfo.getContractType())) {
			queryWrapper.in("contract_type",EnterpriseContractType.b_c_contract.getId(),EnterpriseContractType.b_p_contract.getId());
		}

		if(StringUtils.isNotEmpty(enterpriseContractInfo.getContractNo())){
			queryWrapper.eq("contract_no",enterpriseContractInfo.getContractNo());
		}

		if(StringUtils.isNotEmpty(enterpriseContractInfo.getContractName())){
			queryWrapper.like("contract_name",enterpriseContractInfo.getContractName());
		}
		queryWrapper.orderByDesc("create_time");

		Page<EnterpriseContractInfo> page = new Page<EnterpriseContractInfo>(pageNo, pageSize);
		IPage<EnterpriseContractInfo> pageList = enterpriseContractInfoService.page(page, queryWrapper);

		//返回的分页信息
		PageBean<EnterpriseContractInfo> pageBean = new PageBean<>();
		pageBean.setData(pageList.getRecords());
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(pageList.getTotal());
		pageBean.setTotalPage(pageList.getPages());

		//返回结果
		Result<PageBean<EnterpriseContractInfo>> result = new Result<>();
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
	@AutoLog(value = "企业合同信息-添加")
	@ApiOperation(value="企业合同信息-添加", notes="企业合同信息-添加")
	@PostMapping(value = "/addEnterpriseContract")
	public Result<?> addEnterpriseContract(@RequestBody AddEnterpriseContractInfoModel model) {
		return 	enterpriseContractInfoService.addEnterpriseContract(model);
	}
	
	/**
	 * 编辑
	 *
	 * @param enterpriseContractInfo
	 * @return
	 */
	@AutoLog(value = "企业合同信息-编辑")
	@ApiOperation(value="企业合同信息-编辑", notes="企业合同信息-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody EnterpriseContractInfo enterpriseContractInfo) {
		enterpriseContractInfoService.updateById(enterpriseContractInfo);
		return Result.ok("编辑成功!");
	}
	
	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业合同信息-通过id删除")
	@ApiOperation(value="企业合同信息-通过id删除", notes="企业合同信息-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		enterpriseContractInfoService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "企业合同信息-批量删除")
	@ApiOperation(value="企业合同信息-批量删除", notes="企业合同信息-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.enterpriseContractInfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业合同信息-通过id查询")
	@ApiOperation(value="企业合同信息-通过id查询", notes="企业合同信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		EnterpriseContractInfo enterpriseContractInfo = enterpriseContractInfoService.getById(id);
		return Result.ok(enterpriseContractInfo);
	}

  /**
   * 导出excel
   *
   * @param request
   * @param enterpriseContractInfo
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, EnterpriseContractInfo enterpriseContractInfo) {
      return super.exportXls(request, enterpriseContractInfo, EnterpriseContractInfo.class, "企业合同信息");
  }

  /**
   * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      return super.importExcel(request, response, EnterpriseContractInfo.class);
  }

}
