package com.yjz.notepad.dao;

import com.yjz.notepad.bean.BookkeepingBean;
import com.yjz.notepad.bean.UserBookkeepingBean;

import java.util.List;

/**
 * author： YJZ
 * date:  2018/11/27
 * des: 记账本
 */
public interface IBookkeepingDao {

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
    List<UserBookkeepingBean> queryUserByBookkeepingType(Long userID, Long bookType, String addTime);

}
