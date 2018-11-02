package com.yjz.notepad.controller;

import com.yjz.notepad.bean.R;
import com.yjz.notepad.bean.User;
import com.yjz.notepad.exception.BaseException;
import com.yjz.notepad.service.IUserService;
import com.yjz.notepad.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * author： YJZ
 * date:  2018/10/10
 * des: User
 */

@RequestMapping("/api/user")
@Controller
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> add(User user) {

        System.out.println(user.toString());

        for (User user1 : userService.queryUserAll()) {
            if (user1.getPhone().equals(user.getPhone())) {
                return R.error(BaseException.ERROR_HTTP_300, "用戶已存在");
            }
        }

        if (StringUtil.isEmpty(user.getPassword()) || StringUtil.isEmpty(user.getPhone())) {
            return R.ok("用户数据为空");
        }

        if (user.getRegister_time() == null) {
            user.setRegister_time(new Date());
        }

        Long userId = userService.addUserByObject(user);
        if (userId > 0) {
            return R.ok("注册成功", user.getId());
        } else {
            return R.error(400, "注册失败");
        }
    }

    @RequestMapping(value = "/query_list", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> queryList() {
        List<User> users = userService.queryUserAll();
        if (users.size() > 0) {
            return R.ok("查询成功", users);
        } else {
            return R.error("暂无数据");
        }
    }
}
