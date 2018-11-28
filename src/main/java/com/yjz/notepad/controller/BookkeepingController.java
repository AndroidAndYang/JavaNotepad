package com.yjz.notepad.controller;

import com.yjz.notepad.bean.BookkeepingBean;
import com.yjz.notepad.bean.R;
import com.yjz.notepad.service.IBookkeepingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * author： YJZ
 * date:  2018/11/27
 * des:  记账本
 */
@Controller
@RequestMapping(name = "/api/bookkeeping")
public class BookkeepingController {

    @Resource
    private IBookkeepingService service;

    @ResponseBody
    @RequestMapping(name = "/add", method = RequestMethod.POST)
    public Map<String, Object> getUserMontyRecord(BookkeepingBean bookkeepingBean) {
        Long isSuccess = service.addBookkeepingDate(bookkeepingBean);
        if (isSuccess > 0) {
            return R.ok("记账成功");
        } else {
            return R.error("记账失败");
        }
    }
}
