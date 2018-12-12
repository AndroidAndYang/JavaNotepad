package com.yjz.notepad.controller;

import com.yjz.notepad.bean.*;
import com.yjz.notepad.service.IBookkeepingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author： YJZ
 * date:  2018/11/27
 * des:  记账本
 */
@RequestMapping("/api/bookkeeping")
@Controller
public class BookkeepingController {

    @Resource
    private IBookkeepingService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addBookkeepingDate(BookkeepingBean bookkeepingBean) {
        Long isSuccess = service.addBookkeepingDate(bookkeepingBean);
        if (isSuccess > 0) {
            return R.ok("记账成功");
        } else {
            return R.error("记账失败");
        }
    }

    @RequestMapping(value = "/month_list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getUserMonthDate(Long userId, Long bookType, String yearAndMonth) {
        System.out.println("userId = " + userId + " bookType = " + bookType + " monthStr = " + yearAndMonth);
        List<UserMonthDate> userMonthDates = service.queryBookkeepingDateByMonth(userId, bookType, yearAndMonth);
        if (userMonthDates.size() <= 0) {
            return R.error("暂无数据");
        }
        List<String> dataList = new ArrayList<>();
        HashMap<String, Object> resultMap = new HashMap<>();
        // 一个月的总收入
        float allMonthIn = 0f;
        // 一个月的总支出
        float allMonthOut = 0f;
        // 获取一个月中记账的时间
        for (UserMonthDate userMonthDate : userMonthDates) {
            // 记录一个月中记账了的那一天
            if (!dataList.contains(userMonthDate.getExactTime())) {
                dataList.add(userMonthDate.getExactTime());
            }
            if (userMonthDate.getMoneyType() == 0) {
                // 收入
                allMonthIn += userMonthDate.getMoney();
            } else {
                // 支出
                allMonthOut += userMonthDate.getMoney();
            }
        }
        resultMap.put("allMonthIn", allMonthIn);
        resultMap.put("allMonthOut", allMonthOut);
        List<UserDayDate> userDayDates = new ArrayList<>();
        for (String exactTime : dataList) {
            List<UserBookkeepingBean> userBookkeepingBeans = service.queryAllBookkeeping(userId, bookType, exactTime);
            float allIn = 0f;
            float allOut = 0f;
            for (UserBookkeepingBean userBookkeepingBean : userBookkeepingBeans) {
                if (userBookkeepingBean.getMoneyType() == 0) {
                    // 当天总收入
                    allIn += userBookkeepingBean.getMoney();
                } else {
                    // 当天总支出
                    allOut += userBookkeepingBean.getMoney();
                }
            }
            userDayDates.add(new UserDayDate(allIn, allOut, userBookkeepingBeans));
        }
        resultMap.put("dayData", userDayDates);
        return R.ok("请求成功", resultMap);
    }
}
