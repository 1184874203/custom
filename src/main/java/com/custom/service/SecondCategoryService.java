package com.custom.service;

import com.custom.entity.SecondCategory;
import com.custom.entity.dto.SecondCodeDto;

import java.util.List;

/**
 * (SecondCategory)表服务接口
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
public interface SecondCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SecondCategory queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SecondCategory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param secondCategory 实例对象
     * @return 实例对象
     */
    SecondCategory insert(SecondCategory secondCategory);

    /**
     * 修改数据
     *
     * @param secondCategory 实例对象
     * @return 实例对象
     */
    SecondCategory update(SecondCategory secondCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过一级类目code查询对应二级类目
     *
     * @param code
     * @return
     */
    List<SecondCodeDto> queryScByFc(String code);
}