package com.yjz.notepad.bean;

import java.util.HashMap;

/**
 * author： YJZ
 * date:  2018/10/18
 * des: 返回数据的基类
 */
public class R extends HashMap<String, Object> {

    private static final String status = "status";
    private static final String message = "message";
    private static final String data = "data";

    private R() {
        put(status, 200);
        put(message, "操作成功");
    }

    public R(int code, String msg) {
        put(status, code);
        put(message, msg);
    }

    public static R error() {
        return error(1, "操作失败");
    }

    public static R error(int code, String msg) {
        return new R(code, msg);
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R ok(String msg, Object object) {
        R r = new R();
        r.put(message, msg);
        r.put(data, object);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put(message, msg);
        return r;
    }

    public static R ok(HashMap<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }
}
