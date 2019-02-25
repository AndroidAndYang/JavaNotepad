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
    private Long id;
    // 账本名称
    private String name;
    // 0收入 1支出
    private Long moneyType;
    // 内容
    private String content;
    // 金额
    private float money;
    // 真实日期
    private String exactTime;
    // 类型
    private Long classificationId;
}
