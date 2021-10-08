package com.custom.controller;

import com.custom.entity.FirstSecondMap;
import com.custom.service.FirstSecondMapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (FirstSecondMap)表控制层
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
@RestController
@RequestMapping("firstSecondMap")
public class FirstSecondMapController {
    /**
     * 服务对象
     */
    @Resource
    private FirstSecondMapService firstSecondMapService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public FirstSecondMap selectOne(Integer id) {
        return this.firstSecondMapService.queryById(id);
    }

}