package com.lakers.service.impl;

import com.lakers.dao.AccountDao;
import com.lakers.dao.impl.AccountDaoImpl;
import com.lakers.domain.Account;
import com.lakers.service.AccountService;
import com.lakers.uitl.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: panyusheng
 * @Date: 2020/5/14 0:46
 * @Version 1.0
 */
public class AccountServiceImpl implements AccountService {
    public List<Account> findAllAccount() {
        return null;
    }

    public Account findAccountById(Integer accountId) {
        return null;
    }

    public void saveAccount(Account account) {
        System.out.println("执行了保存");
    }

    public void updateAccount(Account account) {
        System.out.println("执行了更新"+account);
    }

    public void deleteAccount(Integer accountId) {
        System.out.println("执行了删除");
    }

    public void transfer(String sourceName, String targetName, Float money) {

    }

//    @Autowired
//    @Qualifier("accountDaoImpl")
//    @Resource(name = "accountDaoImpl")
//    private AccountDao accountDao;
//
//    private TransactionManager txManager;
//
//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
//
//    public void setTxManager(TransactionManager txManager) {
//        this.txManager = txManager;
//    }
//
//    public List<Account> findAllAccount() {
//        try {
//            txManager.beginTransaction();
//            List<Account> accounts = accountDao.findAllAccount();
//            txManager.commit();
//            return accounts;
//        } catch (Exception e) {
//            txManager.rollback();
//            throw new RuntimeException(e);
//        } finally {
//            txManager.release();
//        }
//    }
//
//    public Account findAccountById(Integer accountId) {
//        return accountDao.findAccountById(accountId);
//    }
//
//    public void saveAccount(Account account) {
//        accountDao.saveAccount(account);
//    }
//
//    public void updateAccount(Account account) {
//        accountDao.updateAccount(account);
//    }
//
//    public void deleteAccount(Integer accountId) {
//        accountDao.deleteAccount(accountId);
//    }
//
//    public void transfer(String sourceName, String targetName, Float money) {
//        Account source = accountDao.findByName(sourceName);
//        Account target = accountDao.findByName(targetName);
//        source.setMoney(source.getMoney()-money);
//        target.setMoney(target.getMoney()+money);
//        //更新两个账户
//        accountDao.updateAccount(source);
//        //模拟转账异常
//        int i=1/0;
//        accountDao.updateAccount(target);
//    }




}
