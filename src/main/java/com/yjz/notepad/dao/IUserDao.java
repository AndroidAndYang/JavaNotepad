package com.yjz.notepad.dao;

import com.yjz.notepad.bean.User;

import java.util.List;

/**
 * author： YJZ
 * date:  2018/10/10
 * des: user 功能相关
 */
public interface IUserDao {

    /**
     * 查詢全部
     *
     * @return user List
     */
    List<User> queryUserAll();

    /**
     * @param user user
     * @return 插入的主键ID
     */
    Long addUserByObject(User user);

    /**
     * 查询单个用户
     *
     * @param id 用戶id
     * @return userBean
     */
    User queryUserById(Long id);

    /**
     * @param id userID
     * @return 成功的状态
     */
    int deleteUserById(Long id);
}
