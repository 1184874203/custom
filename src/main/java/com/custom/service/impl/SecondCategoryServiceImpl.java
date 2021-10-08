package com.custom.service.impl;

import com.custom.entity.SecondCategory;
import com.custom.dao.SecondCategoryDao;
import com.custom.entity.dto.SecondCodeDto;
import com.custom.service.SecondCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SecondCategory)表服务实现类
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
@Service("secondCategoryService")
public class SecondCategoryServiceImpl implements SecondCategoryService {
    @Resource
    private SecondCategoryDao secondCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SecondCategory queryById(Integer id) {
        return this.secondCategoryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SecondCategory> queryAllByLimit(int offset, int limit) {
        return this.secondCategoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param secondCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SecondCategory insert(SecondCategory secondCategory) {
        this.secondCategoryDao.insert(secondCategory);
        return secondCategory;
    }

    /**
     * 修改数据
     *
     * @param secondCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SecondCategory update(SecondCategory secondCategory) {
        this.secondCategoryDao.update(secondCategory);
        return this.queryById(secondCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.secondCategoryDao.deleteById(id) > 0;
    }

    /**
     * 通过一级类目code查询对应二级类目
     *
     * @param code
     * @return
     */
    @Override
    public List<SecondCodeDto> queryScByFc(String code) {
        return secondCategoryDao.queryScByFc(code);
    }
}