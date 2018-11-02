package com.yjz.notepad.test;

import com.yjz.notepad.bean.User;
import com.yjz.notepad.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * author： YJZ
 * date:  2018/10/17
 * des: User 相关功能测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class UserTest {

    @Resource
    private IUserService userService;

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
        user.setPassword("YJZ");
        user.setPhone("17621859608");
        Date date = new Date();
        user.setRegister_time(date);
        Long userID = userService.addUserByObject(user);
        if (userID > 0) {
            System.out.println("插入成功" + user.getId());
        }
    }

    @Test
    public void testDeleteUserById() {
        int deleteState = userService.deleteUserById(1L);
        if (deleteState > 0) {
            System.out.println("刪除成功");
        }
    }
}
