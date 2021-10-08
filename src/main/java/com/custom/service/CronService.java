package com.custom.service;

import com.custom.entity.Cron;
import java.util.List;

/**
 * (Cron)表服务接口
 *
 * @author 邵禹寒
 * @since 2021-09-29 17:15:08
 */
public interface CronService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cron queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cron> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param cron 实例对象
     * @return 实例对象
     */
    Cron insert(Cron cron);

    /**
     * 修改数据
     *
     * @param cron 实例对象
     * @return 实例对象
     */
    Cron update(Cron cron);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}