package com.custom.service.impl;

import com.custom.entity.Tryxx;
import com.custom.dao.TryxxDao;
import com.custom.service.TryxxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tryxx)表服务实现类
 *
 * @author 邵禹寒
 * @since 2021-10-13 18:16:58
 */
@Service("tryxxService")
public class TryxxServiceImpl implements TryxxService {
    @Resource
    private TryxxDao tryxxDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Tryxx queryById(Integer id) {
        return this.tryxxDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Tryxx> queryAllByLimit(int offset, int limit) {
        return this.tryxxDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tryxx 实例对象
     * @return 实例对象
     */
    @Override
    public Tryxx insert(Tryxx tryxx) {
        this.tryxxDao.insert(tryxx);
        return tryxx;
    }

    /**
     * 修改数据
     *
     * @param tryxx 实例对象
     * @return 实例对象
     */
    @Override
    public Tryxx update(Tryxx tryxx) {
        this.tryxxDao.update(tryxx);
        return this.queryById(tryxx.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tryxxDao.deleteById(id) > 0;
    }
}