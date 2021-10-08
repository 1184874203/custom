package com.custom.service.impl;

import com.custom.entity.FirstCategory;
import com.custom.dao.FirstCategoryDao;
import com.custom.service.FirstCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FirstCategory)表服务实现类
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:07
 */
@Service("firstCategoryService")
public class FirstCategoryServiceImpl implements FirstCategoryService {
    @Resource
    private FirstCategoryDao firstCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public FirstCategory queryById(Integer id) {
        return this.firstCategoryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<FirstCategory> queryAllByLimit(int offset, int limit) {
        return this.firstCategoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param firstCategory 实例对象
     * @return 实例对象
     */
    @Override
    public FirstCategory insert(FirstCategory firstCategory) {
        this.firstCategoryDao.insert(firstCategory);
        return firstCategory;
    }

    /**
     * 修改数据
     *
     * @param firstCategory 实例对象
     * @return 实例对象
     */
    @Override
    public FirstCategory update(FirstCategory firstCategory) {
        this.firstCategoryDao.update(firstCategory);
        return this.queryById(firstCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.firstCategoryDao.deleteById(id) > 0;
    }
}