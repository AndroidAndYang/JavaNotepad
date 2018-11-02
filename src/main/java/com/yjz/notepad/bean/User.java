package com.yjz.notepad.bean;

import lombok.Data;

import java.util.Date;

/**
 * author： YJZ
 * date:  2018/10/10
 * des: UserBean
 */

@Data
public class User {

    private Long id;
    private String phone;
    private String password;
    private Date register_time;

}
