package com.yjz.notepad.controller;

import com.yjz.notepad.bean.BaseBean;
import com.yjz.notepad.bean.User;
import com.yjz.notepad.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    @RequestMapping(value = "/v1/add", method = RequestMethod.POST)
    public BaseBean add(User user) {
        int i = userService.addUserByObject(user);
        BaseBean baseBean = new BaseBean();
        baseBean.setMessage(i == 1 ? "添加成功" : "添加失败");
        baseBean.setStatus(i == 1 ? 200 : 400);
        return baseBean;
    }

    @RequestMapping(value = "/v1/query_list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> queryList() {
        return userService.queryUserAll();
    }
}
