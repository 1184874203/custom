package com.custom.service;

import com.custom.entity.FirstCategory;

import java.util.List;

/**
 * (FirstCategory)表服务接口
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:07
 */
public interface FirstCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FirstCategory queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<FirstCategory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param firstCategory 实例对象
     * @return 实例对象
     */
    FirstCategory insert(FirstCategory firstCategory);

    /**
     * 修改数据
     *
     * @param firstCategory 实例对象
     * @return 实例对象
     */
    FirstCategory update(FirstCategory firstCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}