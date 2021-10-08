package com.custom.controller;

import com.custom.entity.Cron;
import com.custom.service.CronService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Cron)表控制层
 *
 * @author 邵禹寒
 * @since 2021-09-29 17:15:08
 */
@RestController
@RequestMapping("cron")
public class CronController {
    /**
     * 服务对象
     */
    @Resource
    private CronService cronService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Cron selectOne(Integer id) {
        return this.cronService.queryById(id);
    }

}