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
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
