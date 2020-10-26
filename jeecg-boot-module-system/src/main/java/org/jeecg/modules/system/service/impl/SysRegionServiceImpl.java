package org.jeecg.modules.system.service.impl;

import org.checkerframework.checker.units.qual.A;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.system.entity.SysRegion;
import org.jeecg.modules.system.mapper.SysRegionMapper;
import org.jeecg.modules.system.service.ISysRegionService;
import org.jeecg.modules.system.vo.SysRegionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 城市
 * @Author: jeecg-boot
 * @Date:   2020-05-12
 * @Version: V1.0
 */
@Service
public class SysRegionServiceImpl extends ServiceImpl<SysRegionMapper, SysRegion> implements ISysRegionService {

    @Autowired
    private SysRegionMapper regionMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Result<List<SysRegionVO>> getSysRegion() {
        Result<List<SysRegionVO>> result = new Result<>();

        Object re = redisUtil.get("sysRegion");
        if(re!=null){
            List<SysRegionVO> r = (List<SysRegionVO>) re;
            result.setResult(r);
        }else {
            List<SysRegionVO> r1 = regionMapper.getSysRegionByPid(0);
            if(!r1.isEmpty()){
                for (SysRegionVO s1 : r1) {
                    List<SysRegionVO> r2 = regionMapper.getSysRegionByPid(s1.getValue());
                    if(!r2.isEmpty()){
                        s1.setChildren(r2);
                        for (SysRegionVO s2 : r2) {
                            List<SysRegionVO> r3 = regionMapper.getSysRegionByPid(s2.getValue());
                            s2.setChildren(r3);
                        }
                    }
                }
            }
            redisUtil.set("sysRegion",r1,60*60*24);
            result.setResult(r1);
        }
        return result;
    }
}
