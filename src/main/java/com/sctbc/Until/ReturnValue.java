package com.sctbc.Until;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

//这是接口返回规范
@ApiModel("api通用返回数据")
public class ReturnValue<T> implements Serializable {
    private static final long serialVersionUID= -1959544190118740608L;

    @ApiModelProperty("标识代码 返回值请看文档")
    private int code;//返回的接口状态码

    @ApiModelProperty("返回的提示信息")
    private String message;//返回的信息

    @ApiModelProperty("有数据时 返回的数据信息")
    private T data; //返回数据


    //默认没有数据返回
    public ReturnValue() {
        this.code=0;
        this.message="";
        this.data=null;
    }

    public ReturnValue(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ReturnValue(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReturnValue{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
