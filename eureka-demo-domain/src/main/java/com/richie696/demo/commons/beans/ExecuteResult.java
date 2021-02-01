package com.richie696.demo.commons.beans;

import com.richie696.demo.account.domain.ResultCode;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>类描述：执行结果实体类
 * <pre>
 * 改动说明：
 *      【修改人：王锦阳 / 2015年12月3日 下午2:51:55 / 版本：1.0】
 *      初始版本创建
 *      【修改人：王锦阳 / 2018年03月23日 上午11:17:55 / 版本：2.0】
 * </pre>
 *
 * @param <T> 执行结果的具体类型
 * @author richie696
 * @version 2.0
 * @since 2018年03月23日 上午11:17:55
 */
public class ExecuteResult<T> implements Serializable {

    /**
     * 请求令牌
     */
    private String token;
    /**
     * 结果数据
     */
    private T data;
    /**
     * 结果代码
     */
    private Integer resultCode = ResultCode.SUCCESS.getCode();
    /**
     * 成功提示消息
     */
    private String successMessage;
    /**
     * 普通的错误信息
     */
    private String errorMessage;
    /**
     * 警告信息
     */
    private String warningMessage;

    public ExecuteResult() {
    }

    public ExecuteResult(T data) {
        this.data = data;
    }

    /**
     * 创建成功结果对象的方法
     *
     * @param <T> 返回结果集类型
     * @return 返回成功结果
     */
    public static <T> ExecuteResult<T> getSuccess() {
        return new ExecuteResult<>();
    }

    /**
     * 创建成功结果对象的方法
     *
     * @param <T> 返回结果集类型
     * @return 返回成功结果
     */
    public static <T> ExecuteResult<T> getSuccess(T data) {
        return new ExecuteResult<>(data);
    }

    /**
     * 创建成功结果对象的方法
     *
     * @param data    返回前端的结果集
     * @param message 消息体
     * @param args    消息参数
     * @param <T>     返回结果集类型
     * @return 返回成功结果
     */
    public static <T> ExecuteResult<T> getSuccessResult(T data, String message, Object... args) {
        ExecuteResult<T> result = getSuccess(data);
        return result.setSuccessMessage(String.format(message, args));
    }

    /**
     * 创建警告结果对象的方法
     *
     * @param message 消息体
     * @param args    消息参数
     * @param <T>     返回结果集类型
     * @return 返回警告结果
     */
    public static <T> ExecuteResult<T> getWarningResult(String message, Object... args) {
        ExecuteResult<T> result = new ExecuteResult<>();
        return result.setWarningMessage(String.format(message, args));
    }

    /**
     * 创建警告结果对象的方法
     *
     * @param data    返回前端的结果集
     * @param message 消息体
     * @param args    消息参数
     * @param <T>     返回结果集类型
     * @return 返回警告结果
     */
    public static <T> ExecuteResult<T> getWarningResult(T data, String message, Object... args) {
        ExecuteResult<T> result = getWarningResult(message, args);
        return result.setData(data);
    }

    /**
     * 创建错误结果对象的方法
     *
     * @param resultCode 应答结果状态码（参考StateCode枚举）
     * @param message 消息体
     * @param args    消息参数
     * @param <T>     返回结果集类型
     * @return 返回错误结果
     * @see ResultCode 应答结果状态码定义枚举类
     */
    public static <T> ExecuteResult<T> getErrorResult(int resultCode, String message, Object... args) {
        ExecuteResult<T> result = new ExecuteResult<>();
        return result.setResultCode(resultCode).setErrorMessage(String.format(message, args));
    }

    /**
     * <p>方法描述：判断当前执行结果是否正确的方法
     *
     * @return 返回结果（true：正确结果，false：错误结果）
     */
    public boolean isSuccess() {
        return Objects.isNull(errorMessage) || errorMessage.trim().isEmpty();
    }

    /**
     * <p>方法描述：判断当前执行结果是否有警告消息的方法
     *
     * @return 返回是否有警告消息（true：有，false：没有）
     */
    public boolean isWarning() {
        return Objects.nonNull(warningMessage) && warningMessage.trim().length() > 0;
    }

    /**
     * <p>方法描述：获取请求令牌的方法
     *
     * @return 返回请求令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * <p>方法描述：设置请求令牌的方法
     *
     * @param token 请求令牌
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * <p>方法描述：获取执行结果的方法
     *
     * @return 返回执行结果
     */
    public T getData() {
        return data;
    }

    /**
     * <p>方法描述：设置执行结果的方法
     *
     * @param data 执行结果
     * @return 返回当前对象
     */
    public ExecuteResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * <p>方法描述：获取结果代码的方法
     *
     * @return 返回结果代码（代码为0代表成功）
     */
    public Integer getResultCode() {
        return resultCode;
    }

    /**
     * <p>方法描述：设置结果代码的方法
     *
     * @param resultCode 结果代码（代码为0代表成功）
     * @return 返回当前对象
     */
    public ExecuteResult<T> setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * <p>方法描述：获取执行成功消息的方法
     *
     * @return 返回执行成功后的消息
     */
    public String getSuccessMessage() {
        return successMessage;
    }

    /**
     * <p>方法描述：设置执行成功消息的方法
     *
     * @param successMessage 执行成功消息
     * @return 返回当前对象
     */
    public ExecuteResult<T> setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
        return this;
    }

    /**
     * <p>方法描述：获取警告信息的方法
     *
     * @return 返回警告信息
     */
    public String getWarningMessage() {
        return warningMessage;
    }

    /**
     * <p>方法描述：设置警告信息的方法
     *
     * @param warningMessage 警告信息
     * @return 返回当前对象
     */
    public ExecuteResult<T> setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
        return this;
    }

    /**
     * <p>方法描述：获取错误信息的方法
     *
     * @return 返回错误信息
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * <p>方法描述：设置错误信息的方法
     *
     * @param errorMessage 错误信息
     * @return 返回当前对象
     */
    public ExecuteResult<T> setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

}
