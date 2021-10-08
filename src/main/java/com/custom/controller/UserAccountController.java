package com.custom.controller;

import com.custom.annotation.CheckToken;
import com.custom.annotation.SetRedis;
import com.custom.constants.ExceptionEnum;
import com.custom.constants.MyException;
import com.custom.constants.Result;
import com.custom.entity.UserAccount;
import com.custom.enums.ExpireType;
import com.custom.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.UUID;

/**
 * (UserAccount)表控制层
 *
 * @author 邵禹寒
 * @since 2021-09-24 10:49:17
 */
@RestController
@RequestMapping("userAccount")
public class UserAccountController {
    /**
     * 服务对象
     */
    @Resource
    private UserAccountService userAccountService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserAccount selectOne(Integer id) {
        return this.userAccountService.queryById(id);
    }


    @GetMapping("login/{account}/{password}")
    @SetRedis(expireType = ExpireType.MINUTE, expireTime = 10)
    public Result login(@PathVariable String account, @PathVariable String password) throws MyException {
        UserAccount result = userAccountService.queryByAccountAndPassword(UserAccount.builder()
                .account(account)
                .password(password)
                .build());
        if (result != null) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            // redisTemplate.opsForValue().set(token, account, Duration.ofSeconds(10L));
            redisTemplate.opsForValue().set(token, result, Duration.ofMinutes(10L));
            return Result.success(token);
        } else {
            throw new MyException(ExceptionEnum.LOGIN_EXCEPTION);
        }
    }

    @PostMapping("post")
    @CheckToken
    public Result post(@RequestBody(required = false) UserAccount userAccount, @RequestParam String name) {
        System.out.println(name);
        return Result.success(userAccount);
    }

}