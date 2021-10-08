package com.custom.service.impl;

import com.custom.dao.FirstSecondMapDao;
import com.custom.entity.FirstSecondMap;
import com.custom.service.FirstSecondMapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FirstSecondMap)表服务实现类
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
@Service("firstSecondMapService")
public class FirstSecondMapServiceImpl implements FirstSecondMapService {
    @Resource
    private FirstSecondMapDao firstSecondMapDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public FirstSecondMap queryById(Integer id) {
        return this.firstSecondMapDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<FirstSecondMap> queryAllByLimit(int offset, int limit) {
        return this.firstSecondMapDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param firstSecondMap 实例对象
     * @return 实例对象
     */
    @Override
    public FirstSecondMap insert(FirstSecondMap firstSecondMap) {
        this.firstSecondMapDao.insert(firstSecondMap);
        return firstSecondMap;
    }

    /**
     * 修改数据
     *
     * @param firstSecondMap 实例对象
     * @return 实例对象
     */
    @Override
    public FirstSecondMap update(FirstSecondMap firstSecondMap) {
        this.firstSecondMapDao.update(firstSecondMap);
        return this.queryById(firstSecondMap.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.firstSecondMapDao.deleteById(id) > 0;
    }
}