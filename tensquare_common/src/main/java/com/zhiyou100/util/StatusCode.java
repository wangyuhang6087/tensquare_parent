package com.zhiyou100.util;

/**
 * @author:Rain
 * @date 2019/10/31 11:22
 * @desc
 */
public class StatusCode {
    public static final int OK = 20000; // 成功
    public static final int ERROR =20001; // 失败
    public static final int LOGINERROR = 20002;  // 用户名或密码错误
    public static final int ACCESSERROR =20003;   // 权限不再
    public static final int REMOTEERROR =20004;  // 远程调用失败
    public static final int REPERROR =20005;  // 重复操作

}
