package com.custom.service.impl;

import com.custom.dao.CronDao;
import com.custom.entity.Cron;
import com.custom.service.CronService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cron)表服务实现类
 *
 * @author 邵禹寒
 * @since 2021-09-29 17:15:08
 */
@Service("cronService")
public class CronServiceImpl implements CronService {
    @Resource
    private CronDao cronDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Cron queryById(Integer id) {
        return this.cronDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Cron> queryAllByLimit(int offset, int limit) {
        return this.cronDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param cron 实例对象
     * @return 实例对象
     */
    @Override
    public Cron insert(Cron cron) {
        this.cronDao.insert(cron);
        return cron;
    }

    /**
     * 修改数据
     *
     * @param cron 实例对象
     * @return 实例对象
     */
    @Override
    public Cron update(Cron cron) {
        this.cronDao.update(cron);
        return this.queryById(cron.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.cronDao.deleteById(id) > 0;
    }
}