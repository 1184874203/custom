package com.custom.dao;

import com.custom.entity.Tryxx;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (Tryxx)表数据库访问层
 *
 * @author 邵禹寒
 * @since 2021-10-13 18:16:58
 */
 @Mapper
public interface TryxxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Tryxx queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Tryxx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tryxx 实例对象
     * @return 对象列表
     */
    List<Tryxx> queryAll(Tryxx tryxx);

    /**
     * 新增数据
     *
     * @param tryxx 实例对象
     * @return 影响行数
     */
    int insert(Tryxx tryxx);

    /**
     * 修改数据
     *
     * @param tryxx 实例对象
     * @return 影响行数
     */
    int update(Tryxx tryxx);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * codes->user
     * @param codes
     * @return
     */
    List<Tryxx> codeToUser(List<String> codes);
}