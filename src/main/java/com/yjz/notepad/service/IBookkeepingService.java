package com.yjz.notepad.service;

import com.yjz.notepad.bean.BookkeepingBean;
import com.yjz.notepad.bean.UserBookkeepingBean;

import java.util.List;

/**
 * author： YJZ
 * date:  2018/11/27
 * des: 记账
 */

public interface IBookkeepingService {

    /**
     * 增加记账数据
     *
     * @param bookkeepingBean 记账数据
     * @return position id
     */
    Long addBookkeepingDate(BookkeepingBean bookkeepingBean);

    /**
     * 查询用户某个月数据
     *
     * @param userID  用戶id
     * @param addTime 添加事件
     * @param bookType 记账本类型
     * @return 某个月的记账数据
     */
    List<String> queryBookkeepingDateByMonth(Long userID, Long bookType, String addTime);

    /**
     * 查询用户某个月所有的记账记录
     *
     * @param userID   用戶id
     * @param exactTime 添加的某一天
     * @param bookType 记账本类型
     * @return 用户某个月所有的记账记录
     */
    List<UserBookkeepingBean> queryAllBookkeeping(Long userID, Long bookType, String exactTime);

}
