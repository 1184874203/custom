package com.custom.service;

import com.custom.entity.News;

import java.util.List;

/**
 * (News)表服务接口
 *
 * @author 邵禹寒
 * @since 2021-09-16 15:20:35
 */
public interface NewsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    News queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<News> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News insert(News news);

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News update(News news);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}