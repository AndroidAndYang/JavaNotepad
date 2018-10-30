package com.yjz.notepad.controller;

import com.yjz.notepad.bean.R;
import com.yjz.notepad.bean.User;
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

        if (StringUtil.isEmpty(user.getUsername()) || StringUtil.isEmpty(user.getPhone())) {
            return R.error(400, "用户数据为空");
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
