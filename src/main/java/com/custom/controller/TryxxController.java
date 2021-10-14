package com.custom.controller;

import com.custom.entity.Tryxx;
import com.custom.service.TryxxService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Tryxx)表控制层
 *
 * @author 邵禹寒
 * @since 2021-10-13 18:17:00
 */
@RestController
@RequestMapping("tryxx")
public class TryxxController {
    /**
     * 服务对象
     */
    @Resource
    private TryxxService tryxxService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Tryxx selectOne(Integer id) {
        return this.tryxxService.queryById(id);
    }

}