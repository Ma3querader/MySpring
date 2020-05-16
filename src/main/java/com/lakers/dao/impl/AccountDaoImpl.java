package com.lakers.dao.impl;

import com.lakers.dao.AccountDao;
import com.lakers.domain.Account;
import com.lakers.uitl.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: panyusheng
 * @Date: 2020/5/14 0:45
 * @Version 1.0
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAllAccount() {
        return null;
    }

    public Account findAccountById(Integer accountId) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ? ",new AccountRowMapper(),accountId);
        return list.isEmpty() ? null : list.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set money = ? where id = ? ",account.getMoney(),account.getId());
    }

    public Account findAccountByName(String name) {
        List<Account> list = jdbcTemplate.query("select * from account where name = ? ",new AccountRowMapper(),name);
        if(list.isEmpty()){
            return null;
        }
        if(list.size()>1){
            throw new RuntimeException("结果集不唯一，不是只有一个账户对象");
        }
        return list.get(0);
    }
}
