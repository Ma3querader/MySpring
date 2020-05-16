package com.lakers.service;

import com.lakers.domain.Account;

import java.util.List;

/**
 * @Author: panyusheng
 * @Date: 2020/5/14 0:45
 * @Version 1.0
 */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     * @return
     */
    void transfer(String sourceName, String targetName, Float money);

}
