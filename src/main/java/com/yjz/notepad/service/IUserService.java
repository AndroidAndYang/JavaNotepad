package com.yjz.notepad.service;

import com.yjz.notepad.bean.User;

import java.util.List;

/**
 * author： YJZ
 * date:  2018/10/10
 * des:
 */
public interface IUserService {

    /**
     * @param user user
     * @return 插入的主键ID
     *
     */
    Long addUserByObject(User user);

    /**
     * @param id userID
     * @return 成功的状态
     */
    int deleteUserById(Long id);

    /**
     * 查詢全部
     *
     * @return user List
     */
    List<User> queryUserAll();
}
