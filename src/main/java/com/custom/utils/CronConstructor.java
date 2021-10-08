package com.custom.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: 邵禹寒
 * @date: 2021-09-30 10:17
 */
@Component
public class CronConstructor {

    public String genCron(String pushTime) {
        String[] time = pushTime.split(":");
        return "0 " + time[1] + " " + time[0] + " * * ?";
    }


    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(LocalDateTime.now().format(formatter));
    }
}
