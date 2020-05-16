package com.lakers.dao;

import com.lakers.domain.Account;

import java.util.List;

/**
 * @Author: panyusheng
 * @Date: 2020/5/14 0:43
 * @Version 1.0
 */
public interface AccountDao {
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
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 根据名字查询
     * @param name
     */
    Account findAccountByName(String name);
}
