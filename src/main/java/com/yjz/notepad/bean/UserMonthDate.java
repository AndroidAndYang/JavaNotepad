package com.yjz.notepad.bean;

import lombok.Data;

/**
 * author： YJZ
 * date:  2018/12/11
 * des:
 */
@Data
public class UserMonthDate {
    // 0收入 1支出
    private Long moneyType;
    // 金额
    private float money;
    // 真实日期
    private String exactTime;
}
