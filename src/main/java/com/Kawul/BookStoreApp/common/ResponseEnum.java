package com.Kawul.BookStoreApp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum ResponseEnum {
    SUCCESS(20000, "成功"),
    ERROR(10001, "服务器内部错误"),
    PARAMS_ERROR(10002, "参数不合法"),
    ERROR_TOKEN(50008, "非法的token"),
    NOT_LOGIN(50009,"未登录"),
    TOKEN_EXPRIE(50014, "Token 过期了"),
    PAGE_ERROR(10003, "page参数不合法"),
    SELECT_NULL_ERROR(10012, "查询为空错误"),
    LOGIN_ERROR(10013, "账号或密码错误"),
    USER_NOT_ACTIVE(10014,"账号未激活");
    private Integer code;
    private String msg;
}