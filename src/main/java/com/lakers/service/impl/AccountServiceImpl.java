package com.lakers.service.impl;

import com.lakers.dao.AccountDao;
import com.lakers.dao.impl.AccountDaoImpl;
import com.lakers.domain.Account;
import com.lakers.service.AccountService;
import com.lakers.uitl.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: panyusheng
 * @Date: 2020/5/14 0:46
 * @Version 1.0
 */
@Service("accountService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void transfer(String sourceName, String targetName, Float money) {
        //1.根据名称查询两个账户
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        //2.修改两个账户的金额
        source.setMoney(source.getMoney()-money);//转出账户减钱
        target.setMoney(target.getMoney()+money);//转入账户加钱
        //3.更新两个账户
        accountDao.updateAccount(source);
        int i=1/0;
        accountDao.updateAccount(target);
    }
}
