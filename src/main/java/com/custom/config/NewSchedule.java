package com.custom.config;

import com.custom.dao.CronDao;
import com.custom.dao.UserDao;
import com.custom.entity.User;
import com.custom.utils.CronConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author: 邵禹寒
 * @date: 2021-09-29 17:16
 */
@Configuration
@EnableScheduling
public class NewSchedule implements SchedulingConfigurer {
    @Resource
    private CronDao cronDao;

    @Resource
    private CronConstructor cronConstructor;

    @Resource
    private UserDao userDao;

    @Resource
    private RedisTemplate redisTemplate;


    // private List<String> pushTimes;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        /**
         * 每天0点准时开跑的定时任务，用来取到所有用户选择的推送时间
         * 将每个时间的用户数据存入redis
         */
        taskRegistrar.addTriggerTask(() -> {
            List<String> pushTimes = userDao.queryPushTimes();
            pushTimes
                    .forEach(e -> redisTemplate.opsForValue().set(e, userDao.queryByPushTime(e), Duration.ofHours(24L)));
            System.out.println(pushTimes);
        }, trigger -> new CronTrigger("0 09 16 * * ?").nextExecutionTime(trigger));

        /**
         * 每分钟 跑的定时任务，每次从当前时间作为key，从redis中取数据
         * 如果能取到，证明这个时间存在用户，则需要对这些用户进行操作
         */
        taskRegistrar.addTriggerTask(() -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            // LocalDateTime.now().getMinute()
            List<User> users = (List<User>) redisTemplate.opsForValue().get(LocalDateTime.now().format(dateTimeFormatter));
            if (users != null && !users.isEmpty()) {
                users
                        .forEach(System.out::println);
            }
        }, t -> new CronTrigger("0 * * * * ?").nextExecutionTime(t));
        // taskRegistrar.addTriggerTask(
        //         //1.添加任务内容(Runnable)
        //         () -> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
        //         //2.设置执行周期(Trigger)
        //         triggerContext -> {
        //             //2.1 从数据库获取执行周期
        //             String cron = cronDao.queryCorn();
        //             //2.2 合法性校验.
        //             if (cron == null || cron.isEmpty()) {
        //                 cron = "0/5 * * * * ?";
        //             }
        //             //2.3 返回执行周期(Date)
        //             return new CronTrigger(cron).nextExecutionTime(triggerContext);
        //         }
        // );
    }
}
