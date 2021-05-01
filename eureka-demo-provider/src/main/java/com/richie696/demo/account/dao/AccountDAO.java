package com.richie696.demo.account.dao;

import com.richie696.demo.account.domain.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<AccountInfo, Long> {
}
