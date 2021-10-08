package com.custom.dao;

import com.custom.entity.Cron;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (Cron)表数据库访问层
 *
 * @author 邵禹寒
 * @since 2021-09-29 17:15:08
 */
 @Mapper
public interface CronDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cron queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cron> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param cron 实例对象
     * @return 对象列表
     */
    List<Cron> queryAll(Cron cron);

    /**
     * 新增数据
     *
     * @param cron 实例对象
     * @return 影响行数
     */
    int insert(Cron cron);

    /**
     * 修改数据
     *
     * @param cron 实例对象
     * @return 影响行数
     */
    int update(Cron cron);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 得到corn表达式
     *
     * @return
     */
    String queryCorn();
}