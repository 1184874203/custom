package com.custom.controller;

import com.custom.entity.Problem;
import com.custom.service.ProblemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Problem)表控制层
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
@RestController
@RequestMapping("problem")
public class ProblemController {
    /**
     * 服务对象
     */
    @Resource
    private ProblemService problemService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Problem selectOne(Integer id) {
        return this.problemService.queryById(id);
    }

}