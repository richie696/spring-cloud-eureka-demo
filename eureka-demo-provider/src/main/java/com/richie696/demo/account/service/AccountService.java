package com.richie696.demo.account.service;

import com.richie696.demo.account.domain.AccountInfo;
import com.richie696.demo.commons.beans.ExecuteResult;

public interface AccountService {

    /**
     * 执行登录操作的方法
     *
     * @param loginName 登录名字
     * @param password 登录密码
     * @return 返回登录结果
     */
    ExecuteResult<AccountInfo> doLogin(String loginName, String password);

    /**
     * 执行注册新帐号的方法
     *
     * @param accountInfo 注册的帐号信息
     * @return 返回注册结果
     */
    ExecuteResult<AccountInfo> doRegister(AccountInfo accountInfo);

}
