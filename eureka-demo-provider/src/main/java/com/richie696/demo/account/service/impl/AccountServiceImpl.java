package com.richie696.demo.account.service.impl;

import com.richie696.demo.account.dao.AccountDAO;
import com.richie696.demo.account.domain.AccountInfo;
import com.richie696.demo.account.domain.ResultCode;
import com.richie696.demo.account.service.AccountService;
import com.richie696.demo.commons.beans.ExecuteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public ExecuteResult<AccountInfo> doLogin(String loginName, String password) {
        Example<AccountInfo> example = Example.of(new AccountInfo().setLoginName(loginName).setDeletedFlag(false));
        Optional<AccountInfo> optional = accountDAO.findOne(example);
        if (optional.isEmpty()) {
            return ExecuteResult.getErrorResult(
                    ResultCode.ERROR_LOGIN.getCode(), "用户名或密码错误，请重试！");
        }
        AccountInfo accountInfo = optional.get();
        if (accountInfo.isInvalidPassword(password)) {
            return ExecuteResult.getErrorResult(
                    ResultCode.ERROR_LOGIN.getCode(), "用户名或密码错误，请重试！");
        }
        return ExecuteResult.getSuccess(accountInfo.clearPassword());
    }

    @Override
    public ExecuteResult<AccountInfo> doRegister(AccountInfo accountInfo) {

        return null;
    }
}
