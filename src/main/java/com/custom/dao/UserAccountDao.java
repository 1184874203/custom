package com.custom.dao;

import com.custom.entity.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserAccount)表数据库访问层
 *
 * @author 邵禹寒
 * @since 2021-09-24 10:49:17
 */
@Mapper
public interface UserAccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserAccount queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserAccount> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userAccount 实例对象
     * @return 对象列表
     */
    List<UserAccount> queryAll(UserAccount userAccount);

    /**
     * 新增数据
     *
     * @param userAccount 实例对象
     * @return 影响行数
     */
    int insert(UserAccount userAccount);

    /**
     * 修改数据
     *
     * @param userAccount 实例对象
     * @return 影响行数
     */
    int update(UserAccount userAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过account和password查询
     *
     * @param userAccount
     * @return
     */
    UserAccount queryByAccountAndPassword(UserAccount userAccount);
}