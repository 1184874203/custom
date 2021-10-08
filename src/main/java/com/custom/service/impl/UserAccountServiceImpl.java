package com.custom.service.impl;

import com.custom.dao.UserAccountDao;
import com.custom.entity.UserAccount;
import com.custom.service.UserAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserAccount)表服务实现类
 *
 * @author 邵禹寒
 * @since 2021-09-24 10:49:17
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {
    @Resource
    private UserAccountDao userAccountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserAccount queryById(Integer id) {
        return this.userAccountDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserAccount> queryAllByLimit(int offset, int limit) {
        return this.userAccountDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userAccount 实例对象
     * @return 实例对象
     */
    @Override
    public UserAccount insert(UserAccount userAccount) {
        this.userAccountDao.insert(userAccount);
        return userAccount;
    }

    /**
     * 修改数据
     *
     * @param userAccount 实例对象
     * @return 实例对象
     */
    @Override
    public UserAccount update(UserAccount userAccount) {
        this.userAccountDao.update(userAccount);
        return this.queryById(userAccount.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userAccountDao.deleteById(id) > 0;
    }

    /**
     * 通过account和password查询
     *
     * @param userAccount
     * @return
     */
    @Override
    public UserAccount queryByAccountAndPassword(UserAccount userAccount) {
        return userAccountDao.queryByAccountAndPassword(userAccount);
    }
}