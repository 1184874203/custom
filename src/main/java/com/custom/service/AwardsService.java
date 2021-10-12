package com.custom.service;

import com.custom.entity.Awards;

import java.util.List;
import java.util.Map;

/**
 * (Awards)表服务接口
 *
 * @author 邵禹寒
 * @since 2021-10-11 13:34:26
 */
public interface AwardsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Awards queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Awards> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param awards 实例对象
     * @return 实例对象
     */
    Awards insert(Awards awards);

    /**
     * 修改数据
     *
     * @param awards 实例对象
     * @return 实例对象
     */
    Awards update(Awards awards);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 生成
     *
     * @return
     */
    Map<String, Integer> genAward();

}