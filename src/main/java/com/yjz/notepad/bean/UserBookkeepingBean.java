package com.yjz.notepad.bean;

import lombok.Data;

/**
 * author： YJZ
 * date:  2018/11/28
 * des:
 */
@Data
public class UserBookkeepingBean {

    // 用户ID
    private Long userId;
    // item 描述
    private String des;
    // 账本名称
    private String name;
    // 支出还是收入
    private Long moneyType;
    // 内容
    private String content;
    // 金额
    private float money;
    // 真实日期
    private String exactTime;
}