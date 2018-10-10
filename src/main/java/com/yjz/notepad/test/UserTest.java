package com.yjz.notepad.test;

import com.yjz.notepad.bean.User;
import com.yjz.notepad.dao.IUserDao;
import com.yjz.notepad.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * author： YJZ
 * date:  2018/10/10
 * des: User 相关功能测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserTest {

    @Resource
    private UserService userService;

    @Test
    public void testQueryUserAll() {
        List<User> users = userService.queryUserAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testAddUserByObject() {
        User user = new User();
        user.setUsername("LNX");
        user.setRegister_time(new Date());
        int addState = userService.addUserByObject(user);
        if (addState > 0) {
            System.out.println("插入成功");
        }
    }

    @Test
    public void testDeleteUserById() {
        int deleteState = userService.deleteUserById(27L);
        if (deleteState > 0) {
            System.out.println("刪除成功");
        }
    }
}