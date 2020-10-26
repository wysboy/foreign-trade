package org.jeecg.modules.business.admin.enterprise.controller;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.modules.business.admin.enterprise.vo.EnterpriseAuthInfoVO;
import org.jeecg.modules.business.admin.enterprise.entity.EnterpriseAuthInfo;
import org.jeecg.modules.business.admin.enterprise.model.AddEnterpriseAuthInfoModel;
import org.jeecg.modules.business.admin.enterprise.model.UpdateEnterpriseAuthInfoModel;
import org.jeecg.modules.business.admin.enterprise.service.IEnterpriseAuthInfoService;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.controller.JeecgController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 企业认证信息
 * @Author: jeecg-boot
 * @Date:   2020-04-24
 * @Version: V1.0
 */
@Slf4j
@Api(tags="企业认证信息")
@RestController
@RequestMapping("/business/enterpriseAuthInfo")
public class EnterpriseAuthInfoController extends JeecgController<EnterpriseAuthInfo, IEnterpriseAuthInfoService> {
	@Autowired
	private IEnterpriseAuthInfoService enterpriseAuthInfoService;

	/**
	 * 添加
	 *
	 * @param model
	 * @return
	 */
	@AutoLog(value = "企业认证信息-添加")
	@ApiOperation(value="企业认证信息-添加", notes="企业认证信息-添加")
	@PostMapping(value = "/addEnterpriseAuthInfo")
	public Result<?> addEnterpriseAuthInfo(@RequestBody AddEnterpriseAuthInfoModel model) {
		return enterpriseAuthInfoService.addEnterpriseAuthInfo(model);
	}
	
	/**
	 * 编辑
	 *
	 * @param model
	 * @return
	 */
	@AutoLog(value = "企业认证信息-编辑")
	@ApiOperation(value="企业认证信息-编辑", notes="企业认证信息-编辑")
	@PutMapping(value = "/updateEnterpriseAuthInfo")
	public Result<?> updateEnterpriseAuthInfo(@RequestBody UpdateEnterpriseAuthInfoModel model) {
		return enterpriseAuthInfoService.updateEnterpriseAuthInfo(model);
	}


	/**
	 * 通过enterpriseId查询查询
	 *
	 * @param enterpriseId
	 * @return
	 */
	@AutoLog(value = "企业认证信息-通过enterpriseId查询查询")
	@ApiOperation(value="企业认证信息-通过enterpriseId查询", notes="企业认证信息-通过id查询")
	@GetMapping(value = "/queryByEnterpriseId/{enterpriseId}")
	public Result<EnterpriseAuthInfoVO> queryByEnterpriseId(@PathVariable("enterpriseId") String enterpriseId) {
		return enterpriseAuthInfoService.queryByEnterpriseId(enterpriseId);
	}


}
