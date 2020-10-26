package org.jeecg.modules.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.system.entity.SysRegion;
import org.jeecg.modules.system.vo.SysRegionVO;

import java.util.List;

/**
 * @Description: 城市
 * @Author: jeecg-boot
 * @Date:   2020-05-12
 * @Version: V1.0
 */
public interface ISysRegionService extends IService<SysRegion> {
    /**
     * 查询系统城市 三级联动
     * @return
     */
    Result<List<SysRegionVO>> getSysRegion();
}
