package com.mxycms.backend.util;

import lombok.Data;

/**
 * @author th
 */
@Data
public class Result<T> {

    /**
     * 错误码 错误码为字符串类型，共 5 位，分成两个部分：错误产生来源+四位数字编号。 错误产生来源分为 A/B/C，A 表示错误来源于用户，比如参数错误，用户安装版本过低，用户支付超时等问题； B
     * 表示错误来源于当前系统，往往是业务逻辑出错，或程序健壮性差等问题；C 表示错误来源于第三方服务，比如 CDN 服务出错，消息投递超时等问题；四位数字编号从 0001 到 9999，大类之间的步长间距预留 100，参考文末附表
     * 3。
     *
     * @see https://github.com/alibaba/p3c/blob/master/Java开发手册(黄山版).pdf#附 3：错误码列表
     */
    private String errorCode;
    private String errorMessage;
    private T data;

    public Result(String errorCode, T data) {
        this.errorCode = errorCode;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>("00000", data);
    }

    /**
     * 用户端错误
     */
    public static <T> Result<T> errorInUser(T data, String errorMessage) {
        Result<T> result = new Result<>("A00001", data);
        result.setErrorMessage(errorMessage);
        return result;
    }

    /**
     * 系统执行出错
     */
    public static <T> Result<T> errorInSystem(T data, String errorMessage) {
        Result<T> result = new Result<>("B00001", data);
        result.setErrorMessage(errorMessage);
        return result;
    }

    /**
     * 调用第三方服务出错
     */
    public static <T> Result<T> errorInRpc(T data, String errorMessage) {
        Result<T> result = new Result<>("C00001", data);
        result.setErrorMessage(errorMessage);
        return result;
    }
}
