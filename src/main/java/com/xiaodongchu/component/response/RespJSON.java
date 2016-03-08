package com.xiaodongchu.component.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.SQLException;

/**
 * 接口返回单个结果的泛型类.
 *
 * @param <T>
 *            响应消息的result子类型
 */
@JsonPropertyOrder(alphabetic = false)
public class RespJSON<T> {

    /** The code. */
    private int code;

    /** The message. */
    private String message;

    /** The result. */
    private T result;

    /**
     * Instantiates a new resp json.
     */
    public RespJSON() {
    }

    /**
     * 根据返回代码生成默认返回对象.
     *
     * @param respCode
     *            the resp code
     */
    public RespJSON(RespCode respCode) {
        this.code = respCode.getCode();
        this.message = respCode.getMeaning();
    }

    /**
     * 无数据返回结果.
     *
     * @param respDataCode
     *            the resp data code
     */
    public RespJSON(RespDataCode respDataCode) {
        this.code = respDataCode.getCode();
        this.message = respDataCode.getMeaning();
    }

    /**
     * 生成自定义返回对象.
     *
     * @param code
     *            错误代码
     * @param msg
     *            错误消息
     */
    public RespJSON(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    /**
     * 生成错误消息.
     *
     * @param message
     *            错误消息体
     */
    public RespJSON(String message) {
        this(new Exception(message));
    }

    /**
     * 生成错误消息.
     *
     * @param exception
     *            抛出的异常
     */
    public RespJSON(Exception exception) {
        if (exception instanceof SQLException) {
            this.code = RespCode.NO_DATA.getCode();
            this.message = RespCode.NO_DATA.toString();
        } else if (exception instanceof IllegalArgumentException) {
            this.code = RespCode.ILLEGAL.getCode();
            this.message = RespCode.ILLEGAL.getMeaning();
        } else {
            this.code = RespCode.RUNTIME_ERR.getCode();
            this.message = exception.getMessage();
        }
    }

    /**
     * 生成成功消息.
     *
     * @param result
     *            返回数据
     */
    public RespJSON(T result) {
        this.code = RespCode.SUCCESS.getCode();
        this.message = RespCode.SUCCESS.getMeaning();
        this.result = result;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code
     *            the new code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets the result.
     *
     * @return the result
     */
    public T getResult() {
        return result;
    }

    /**
     * Sets the result.
     *
     * @param result
     *            the new result
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message
     *            the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}