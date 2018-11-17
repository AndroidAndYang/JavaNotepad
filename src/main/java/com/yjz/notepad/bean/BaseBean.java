package com.yjz.notepad.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 *     author: YJZ
 *     time  : 2017/3/12  10:20
 *     desc  :
 * </pre>
 */
@Data
public class BaseBean implements Serializable {
    private boolean isSuccess;
    private String message;
}
