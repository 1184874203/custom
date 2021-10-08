package com.custom.utils;

import com.alibaba.fastjson.JSONObject;
import com.custom.constants.ExceptionEnum;
import com.custom.constants.MyException;
import com.custom.entity.UserAccount;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author: 邵禹寒
 * @date: 2021-09-06 14:02
 */
@Aspect
@Component
public class MyAop {
    @Resource
    private Logger myLogger;

    @Resource
    private RedisTemplate redisTemplate;

    @Pointcut("execution(public * com.custom.controller.*.*(..))")
    public void myPointcut() {

    }

    @Pointcut("@annotation(com.custom.annotation.CheckToken)")
    public void checkToken() {
    }

    @Pointcut("@annotation(com.custom.annotation.SetRedis)")
    public void setRedis() {

    }

    @Around("myPointcut()")
    public Object testAround(ProceedingJoinPoint pjp) throws Throwable {
        myLogger.info("开始执行方法:" + pjp.getSignature());
        LocalDateTime begin = LocalDateTime.now();
        Object proceed = pjp.proceed();
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(begin, end);
        myLogger.info("执行时间：" + duration.toMillis() + "ms");
        return proceed;
    }


    @Around("checkToken()")
    public Object token(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            throw new MyException(ExceptionEnum.TOKEN_EXCEPTION);
        }
        Object o = redisTemplate.opsForValue().get(token);
        if (o == null) {
            throw new MyException(ExceptionEnum.TOKEN_MISSING);
        }
        UserAccount userAccount = JSONObject.parseObject(JSONObject.toJSONString(o), UserAccount.class);
        Object[] args = pjp.getArgs();
        myLogger.info("args:{}", Arrays.asList(args));
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof UserAccount) {
                args[i] = userAccount;
                break;
            }
        }
        // List<Object> args = Arrays.asList(pjp.getArgs());
        // List<UserAccount> user = args.stream()
        //         .filter(e -> e instanceof UserAccount)
        //         .map(e -> userAccount)
        //         .collect(Collectors.toList());
        // List<Object> collect = args.stream()
        //         .filter(e -> !(e instanceof UserAccount))
        //         .collect(Collectors.toList());
        // collect.addAll(user);
        return pjp.proceed(args);
    }

    // @Around("setRedis()")
    // public Result setRedis(ProceedingJoinPoint pjp) throws Throwable {
    //     Signature signature = pjp.getSignature();
    //     MethodSignature methodSignature = (MethodSignature) signature;
    //     Method method = methodSignature.getMethod();
    //     SetRedis annotation = method.getAnnotation(SetRedis.class);
    //     Object o = pjp.proceed();
    //     String token = UUID.randomUUID().toString().replaceAll("-", "");
    //     redisTemplate.opsForValue().set(token, o, new ExpireFactory().genDuration(annotation.expireType(), annotation.expireTime()));
    //     return Result.success(token);
    // }
}

