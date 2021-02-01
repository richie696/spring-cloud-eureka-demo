package com.richie696.demo.account.domain;

/**
 * <p>枚举描述：服务应答状态码枚举类
 * <pre>
 * 改动说明：
 *      【修改人：王锦阳 / 2018年03月23日 上午11:15:13 / 版本：1.0】
 *      初始版本创建
 * </pre>
 *
 * @author richie696
 * @version 1.0
 * @since 2018年03月23日 上午11:15:13
 */
public enum ResultCode {
    /** 成功 */
    SUCCESS(200),
    /** 用户名错误 */
    ERROR_LOGIN(201),
    /** 封禁该IP */
    ERROR_BLOCK_IP(202);

    private final int code;
    ResultCode(int code) {
        this.code = code;
    }

    /**
     * 获取状态码定义的方法
     * @return 返回状态码定义
     */
    public int getCode() {
        return code;
    }

    /**
     * 检查当前指定状态码是否是请求成功的状态码
     *
     * @param code 待检查的状态码
     * @return 返回检查结果（true：成功，false：失败）
     */
    public static boolean isSuccess(int code) {
        return SUCCESS.code == code;
    }

    /**
     * 检查当前指定状态码是否是封禁用户IP的状态码
     *
     * @param code 待检查的状态码
     * @return 返回检查结果（true：封禁，false：不封禁）
     */
    public static boolean isBlockIP(int code) {
        return ERROR_BLOCK_IP.code == code;
    }

}
