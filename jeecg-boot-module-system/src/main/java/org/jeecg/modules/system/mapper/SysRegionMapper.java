package org.jeecg.modules.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.system.entity.SysRegion;
import org.jeecg.modules.system.vo.SysRegionVO;

import java.util.List;

/**
 * @Description: 城市
 * @Author: jeecg-boot
 * @Date:   2020-05-12
 * @Version: V1.0
 */
public interface SysRegionMapper extends BaseMapper<SysRegion> {

    /**
     * 通过Pid查询
     * @param pid
     * @return
     */
    List<SysRegionVO> getSysRegionByPid(@Param("pid") int pid);

    /**
     * 通过Pid查询
     * @param id
     * @return
     */
    List<SysRegionVO> getSysRegionById(@Param("id") int id);
}
