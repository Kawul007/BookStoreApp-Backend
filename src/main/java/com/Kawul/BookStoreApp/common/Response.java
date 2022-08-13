package com.Kawul.BookStoreApp.common;

import lombok.Data;

import java.io.Serializable;

/**\
 * 统一结果集feng
 * @param <E>
 */
@Data
public class Response<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    private E data;     //  返回数据
    private String msg;     // 返回消息
    private Integer code;  // 业务响应码

    private Response() {  // 构造私有化

    }
    public static <E> Response<E> success(E data) {
        Response<E> r = new Response<>();
        r.setData(data);
        r.setMsg(ResponseEnum.SUCCESS.getMsg());
        r.setCode(ResponseEnum.SUCCESS.getCode());

        return r;
    }
    public static <E> Response<E> success() {
        Response<E> r = new Response<>();
        r.setData(null);
        r.setMsg(ResponseEnum.SUCCESS.getMsg());
        r.setCode(ResponseEnum.SUCCESS.getCode());

        return r;
    }

    public static <E> Response<E> success(String msg) {
        Response<E> r = new Response<>();
        r.setData(null);
        r.setMsg(msg);
        r.setCode(ResponseEnum.SUCCESS.getCode());

        return r;
    }

    public static <E> Response<E> success(String msg, E data) {
        Response<E> r = new Response<>();
        r.setData(data);
        r.setMsg(ResponseEnum.SUCCESS.getMsg());

        r.setCode(ResponseEnum.SUCCESS.getCode());
        return r;
    }

    public static <E> Response<E> success(String msg, E data, ResponseEnum restStatusEnum) {
        Response<E> r = new Response<>();
        r.setData(data);
        r.setMsg(msg);
        r.setCode(restStatusEnum.getCode());
        return r;
    }

    //
    public static <E> Response<E> error() {
        Response<E> r = new Response<>();
        r.setData(null);
        r.setMsg(ResponseEnum.ERROR.getMsg());
        r.setCode(ResponseEnum.ERROR.getCode());

        return r;
    }

    public static <E> Response<E> error(String msg) {
        Response<E> r = new Response<>();
        r.setData(null);
        r.setMsg(msg);
//        r.setCode(RestStatus.OK);
        r.setCode(ResponseEnum.ERROR.getCode());
        return r;
    }

    public static <E> Response<E> error(String msg, E data) {
        Response<E> r = new Response<>();
        r.setData(data);
        r.setMsg(ResponseEnum.ERROR.getMsg());

        r.setCode(ResponseEnum.ERROR.getCode());
        return r;
    }

    public static <E> Response<E> error(String msg, E data, ResponseEnum restStatusEnum) {
        Response<E> r = new Response<>();
        r.setData(data);
        r.setMsg(msg);
        r.setCode(restStatusEnum.getCode());
        return r;
    }

    public static <E> Response<E> error(ResponseEnum restStatusEnum) {
        Response<E> r = new Response<>();
        r.setData(null);
        r.setMsg(restStatusEnum.getMsg());
        r.setCode(restStatusEnum.getCode());
        return r;
    }

    /**
     * 设置特定的响应码
     */
    public Response<E> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 设置特定的响应消息
     *
     * @return
     */
    public Response<E> message(String message) {
        this.setMsg(message);
        return this;
    }
}