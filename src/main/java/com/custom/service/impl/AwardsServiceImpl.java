package com.custom.service.impl;

import com.custom.dao.AwardsDao;
import com.custom.entity.Awards;
import com.custom.service.AwardsService;
import com.custom.utils.LuckDraw;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Awards)表服务实现类
 *
 * @author 邵禹寒
 * @since 2021-10-11 13:34:26
 */
@Service("awardsService")
public class AwardsServiceImpl implements AwardsService {
    @Resource
    private AwardsDao awardsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Awards queryById(Integer id) {
        return this.awardsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Awards> queryAllByLimit(int offset, int limit) {
        return this.awardsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param awards 实例对象
     * @return 实例对象
     */
    @Override
    public Awards insert(Awards awards) {
        this.awardsDao.insert(awards);
        return awards;
    }

    /**
     * 修改数据
     *
     * @param awards 实例对象
     * @return 实例对象
     */
    @Override
    public Awards update(Awards awards) {
        this.awardsDao.update(awards);
        return this.queryById(awards.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.awardsDao.deleteById(id) > 0;
    }

    @Override
    public Map<String, Integer> genAward() {
        List<Awards> list = awardsDao.queryAll();
        Map<String, Integer> map = new HashMap<>(8);
        for (int i = 0; i < 100000; i++) {
            String value = LuckDraw.genDraw(list).getValue();
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return map;
    }
}