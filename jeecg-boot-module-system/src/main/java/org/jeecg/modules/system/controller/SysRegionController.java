package org.jeecg.modules.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.system.entity.SysRegion;
import org.jeecg.modules.system.service.ISysRegionService;
import org.jeecg.modules.system.vo.SysRegionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 城市
 * @Author: jeecg-boot
 * @Date:   2020-05-12
 * @Version: V1.0
 */
@Slf4j
@Api(tags="城市")
@RestController
@RequestMapping("/sys/sysRegion")
public class SysRegionController extends JeecgController<SysRegion, ISysRegionService> {
	@Autowired
	private ISysRegionService sysRegionService;


	 /**
	  * 查询系统城市 三级联动
	  *
	  * @return
	  */
	 @AutoLog(value = "查询系统城市 三级联动")
	 @ApiOperation(value="查询系统城市 三级联动", notes="查询系统城市 三级联动")
	 @GetMapping(value = "/getSysRegion")
	 public Result<List<SysRegionVO>> getSysRegion() {
		 return sysRegionService.getSysRegion();
	 }


	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "城市-通过id查询")
	@ApiOperation(value="城市-通过id查询", notes="城市-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		SysRegion sysRegion = sysRegionService.getById(id);
		return Result.ok(sysRegion);
	}


}
