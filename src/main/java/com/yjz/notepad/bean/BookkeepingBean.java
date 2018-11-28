package com.yjz.notepad.bean;

import lombok.Data;

import java.util.Date;

/**
 * author： YJZ
 * date:  2018/11/27
 * des:
 */
@Data
public class BookkeepingBean {

    private Long id;
    // 用户ID
    private Long userId;
    // 账本类型
    private Long bookTypeId;
    // 记账类型（例餐饮，出行）
    private Long classificationId;
    // 支出還是收入
    private Long moneyType;
    // 内容
    private String content;
    // 金额
    private float money;
    // 年月数据
    private String addTime;
    // 记账详细时间
    private Date exactAddTime;

}
