package com.yjz.notepad.bean;

import lombok.Data;

import java.util.List;

/**
 * author： YJZ
 * date:  2018/12/11
 * des:
 */

@Data
public class UserDayDate {

    private float allIn;
    private float allOut;
    private List<UserBookkeepingBean> userBookkeepingBeans;

    public UserDayDate(float allIn, float allOut, List<UserBookkeepingBean> userBookkeepingBeans) {
        this.allIn = allIn;
        this.allOut = allOut;
        this.userBookkeepingBeans = userBookkeepingBeans;
    }
}
