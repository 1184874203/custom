package com.custom.service;

import com.custom.entity.FirstSecondMap;

import java.util.List;

/**
 * (FirstSecondMap)表服务接口
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
public interface FirstSecondMapService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FirstSecondMap queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<FirstSecondMap> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param firstSecondMap 实例对象
     * @return 实例对象
     */
    FirstSecondMap insert(FirstSecondMap firstSecondMap);

    /**
     * 修改数据
     *
     * @param firstSecondMap 实例对象
     * @return 实例对象
     */
    FirstSecondMap update(FirstSecondMap firstSecondMap);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}