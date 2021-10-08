package com.custom.controller;

import com.custom.entity.FirstCategory;
import com.custom.service.FirstCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (FirstCategory)表控制层
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:07
 */
@RestController
@RequestMapping("firstCategory")
public class FirstCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private FirstCategoryService firstCategoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public FirstCategory selectOne(Integer id) {
        return this.firstCategoryService.queryById(id);
    }

}