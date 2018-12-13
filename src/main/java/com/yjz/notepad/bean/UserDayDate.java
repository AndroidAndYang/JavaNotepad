package com.yjz.notepad.bean;

import lombok.Data;

import java.util.List;

/**
 * author： YJZ
 * date:  2018/12/11
 * des: 某一天的记账数据
 */

@Data
public class UserDayDate {

    private float allIn;
    private float allOut;
    private String exactTimes;
    private List<UserBookkeepingBean> userBookkeepingBeans;

    public UserDayDate(float allIn, float allOut, String exactTimes, List<UserBookkeepingBean> userBookkeepingBeans) {
        this.allIn = allIn;
        this.allOut = allOut;
        this.exactTimes = exactTimes;
        this.userBookkeepingBeans = userBookkeepingBeans;
    }
}
