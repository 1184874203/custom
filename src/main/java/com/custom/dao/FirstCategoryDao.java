package com.custom.dao;

import com.custom.entity.FirstCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (FirstCategory)表数据库访问层
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:06
 */
@Mapper
public interface FirstCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FirstCategory queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<FirstCategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param firstCategory 实例对象
     * @return 对象列表
     */
    List<FirstCategory> queryAll(FirstCategory firstCategory);

    /**
     * 新增数据
     *
     * @param firstCategory 实例对象
     * @return 影响行数
     */
    int insert(FirstCategory firstCategory);

    /**
     * 修改数据
     *
     * @param firstCategory 实例对象
     * @return 影响行数
     */
    int update(FirstCategory firstCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}