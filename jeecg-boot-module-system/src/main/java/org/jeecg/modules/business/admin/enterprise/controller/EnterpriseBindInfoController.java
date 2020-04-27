package org.jeecg.modules.business.admin.enterprise.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseBindInfo;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseBindInfoModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseBindInfoModel;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseBindInfoService;
import java.util.Date;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 企业绑定信息
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
@Slf4j
@Api(tags="企业绑定信息")
@RestController
@RequestMapping("/business/enterpriseBindInfo")
public class EnterpriseBindInfoController extends JeecgController<EnterpriseBindInfo, IEnterpriseBindInfoService> {
	@Autowired
	private IEnterpriseBindInfoService enterpriseBindInfoService;

	/**
	 * 添加
	 *
	 * @param model
	 * @return
	 */
	@AutoLog(value = "企业绑定信息-添加")
	@ApiOperation(value="企业绑定信息-添加", notes="企业绑定信息-添加")
	@PostMapping(value = "/addEnterpriseBindInfo")
	public Result<?> addEnterpriseBindInfo(@RequestBody AddEnterpriseBindInfoModel model) {
		return enterpriseBindInfoService.addEnterpriseBindInfo(model);
	}
	
	/**
	 * 编辑
	 *
	 * @param model
	 * @return
	 */
	@AutoLog(value = "企业绑定信息-编辑")
	@ApiOperation(value="企业绑定信息-编辑", notes="企业绑定信息-编辑")
	@PutMapping(value = "/updateEnterpriseBindInfo")
	public Result<?> updateEnterpriseBindInfo(@RequestBody UpdateEnterpriseBindInfoModel model) {
		return enterpriseBindInfoService.updateEnterpriseBindInfo(model);
	}
	

	/**
	 * 通过id查询
	 *
	 * @param enterpriseId
	 * @return
	 */
	@AutoLog(value = "企业绑定信息-通过enterpriseId查询")
	@ApiOperation(value="企业绑定信息-通过enterpriseId查询", notes="企业绑定信息-通过enterpriseId查询")
	@GetMapping(value = "/queryByEnterpriseId/{enterpriseId}")
	public Result<?> queryByEnterpriseId(@PathVariable("enterpriseId") String enterpriseId) {
		return enterpriseBindInfoService.queryByEnterpriseId(enterpriseId);
	}


}
