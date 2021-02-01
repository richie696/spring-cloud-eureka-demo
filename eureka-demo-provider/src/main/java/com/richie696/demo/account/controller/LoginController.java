package com.richie696.demo.account.controller;

import com.richie696.demo.account.domain.AccountInfo;
import com.richie696.demo.account.service.AccountService;
import com.richie696.demo.commons.beans.ExecuteResult;
import com.richie696.demo.commons.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class LoginController {

    private final AccountService accountService;

    @Autowired
    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login/{name}/{password}")
    public String login(@PathVariable String name, @PathVariable String password) {
        ExecuteResult<AccountInfo> result = this.accountService.doLogin(name, password);
        return JsonUtils.serialize(result, true);
    }
}
