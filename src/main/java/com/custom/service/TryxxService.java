package com.custom.service;

import com.custom.entity.Tryxx;
import java.util.List;

/**
 * (Tryxx)表服务接口
 *
 * @author 邵禹寒
 * @since 2021-10-13 18:16:58
 */
public interface TryxxService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Tryxx queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Tryxx> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tryxx 实例对象
     * @return 实例对象
     */
    Tryxx insert(Tryxx tryxx);

    /**
     * 修改数据
     *
     * @param tryxx 实例对象
     * @return 实例对象
     */
    Tryxx update(Tryxx tryxx);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}