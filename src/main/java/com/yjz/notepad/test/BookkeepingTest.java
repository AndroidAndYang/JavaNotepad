package com.yjz.notepad.test;

import com.yjz.notepad.bean.BookkeepingBean;
import com.yjz.notepad.bean.UserBookkeepingBean;
import com.yjz.notepad.bean.UserMonthDate;
import com.yjz.notepad.service.IBookkeepingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author： YJZ
 * date:  2018/11/28
 * des:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class BookkeepingTest {

    @Resource
    private IBookkeepingService service;

    /**
     * 添加记账数据
     */
    @Test
    public void testAddBookkeepingData() {
        BookkeepingBean bookkeepingBean = new BookkeepingBean();
        bookkeepingBean.setUserId(19L);
        bookkeepingBean.setBookTypeId(1L);
        bookkeepingBean.setClassificationId(1L);
        bookkeepingBean.setMoneyType(2L);
        bookkeepingBean.setContent("外快");
        bookkeepingBean.setMoney(1222.7f);
        bookkeepingBean.setAddTime("2018-11");
        bookkeepingBean.setExactAddTime(new Date());
        Long isSuccess = service.addBookkeepingDate(bookkeepingBean);
        System.out.println(" isSuccess id = " + isSuccess);
    }

    /**
     * 查詢用户一个月的记账记录
     */
    @Test
    public void testQueryUserByBookkeepingType() {
        List<String> dataList = new ArrayList<>();
        List<UserMonthDate> userBookkeepingBeans = service.queryBookkeepingDateByMonth(2L, 1L, "2018-11");
        float allMonthIn = 0f;
        float allMonthOut = 0f;
        for (UserMonthDate exactDate : userBookkeepingBeans) {
            if (exactDate.getMoneyType() == 0) {
                // 收入
                allMonthIn += exactDate.getMoney();
            } else {
                // 支出
                allMonthOut += exactDate.getMoney();
            }
            if (!dataList.contains(exactDate.getExactTime())) {
                dataList.add(exactDate.getExactTime());
            }
        }
        System.out.println(" allMonthIn = " + allMonthIn + " allMonthOut = " + allMonthOut);
        for (String exactTime : dataList) {
            float allIn = 0f;
            float allOut = 0f;
            List<UserBookkeepingBean> userBookkeepingBeans1 = service.queryAllBookkeeping(2L, 1L, exactTime);
            for (UserBookkeepingBean userBookkeepingBean : userBookkeepingBeans1) {
                if (userBookkeepingBean.getMoneyType() == 1) {
                    // 支出
                    allOut += userBookkeepingBean.getMoney();
                } else {
                    // 收入
                    allIn += userBookkeepingBean.getMoney();
                }
                System.out.println(userBookkeepingBean.toString());
            }
            System.out.println("allIn = " + allIn + " allOut = " + allOut);
            System.out.println("-------------------------------");
        }
    }
}
