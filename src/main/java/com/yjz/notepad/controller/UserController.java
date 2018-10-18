package com.yjz.notepad.controller;

import com.yjz.notepad.bean.R;
import com.yjz.notepad.bean.User;
import com.yjz.notepad.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * author： YJZ
 * date:  2018/10/10
 * des:
 */

@RequestMapping("/api/user")
@Controller
public class UserController {

    @Resource
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HashMap<String, Object> add(User user) {
        int registerStatus = userService.addUserByObject(user);
        if (registerStatus == 1) {
            return R.ok("注册成功", user);
        } else {
            return R.error(400, "注册失败");
        }
    }

    @RequestMapping(value = "/v1/query_list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> queryList() {
        return userService.queryUserAll();
    }
}
