package com.yjz.notepad.service.impl;

import com.yjz.notepad.bean.User;
import com.yjz.notepad.dao.IUserDao;
import com.yjz.notepad.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author： YJZ
 * date:  2018/10/10
 * des: IUserService impl
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public int addUserByObject(User user) {
        return userDao.addUserByObject(user);
    }

    @Override
    public int deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public List<User> queryUserAll() {
        return userDao.queryUserAll();
    }
}
