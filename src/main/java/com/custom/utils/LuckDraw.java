package com.custom.utils;

import com.custom.entity.Awards;

import java.util.List;
import java.util.Random;

/**
 * @author: 邵禹寒
 * @date: 2021-10-11 11:06
 */
public class LuckDraw {
    /**
     * 根据概率生成奖项的算法
     *
     * @param draws
     * @return
     */
    public static Awards genDraw(List<Awards> draws) {
        int temp = 0;
        int line;
        int random = new Random().nextInt(100) + 1;
        Awards result = null;
        for (int i = 0; i < draws.size(); i++) {
            int v = draws.get(i).getRatio();
            temp = temp + v;
            line = 100 - temp;
            if (random > line && random <= (line + v)) {
                result = draws.get(i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt(2));
    }
}
