package com.yjz.notepad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author: YJZ
 * data: 2018/11/24.
 */
@Controller(value = "/bookkeeping")
public class Bookkeeping {

    /**
     * 获取用户的所有记账记录
     *
     * @param userId          用户id
     * @param bookkeepingType 记账本类型
     * @return map
     */
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> queryAllBookkeepingData(Long userId, int bookkeepingType) {
        return null;
    }


}
