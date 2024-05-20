package com.ordersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private int code;//响应返回编码 1--成功, 0--失败
    private String msg;//提示消息
    private T data;//业务数据

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static Result success() {
        return new Result<>(1, "操作成功!", null);
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static Result success(Object data) {
        return new Result<>(1, "操作成功!", data);
    }


    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static Result<Object> error(String msg) {
        return  new Result<>(0, msg, null);
    }

}
