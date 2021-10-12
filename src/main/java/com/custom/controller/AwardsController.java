package com.custom.controller;

import com.custom.service.AwardsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Awards)表控制层
 *
 * @author 邵禹寒
 * @since 2021-10-11 13:34:26
 */
@RestController
@RequestMapping("awards")
public class AwardsController {
    /**
     * 服务对象
     */
    @Resource
    private AwardsService awardsService;


    @GetMapping("genAward")
    public Map<String, Integer> genAward() {
        return awardsService.genAward();
    }

}