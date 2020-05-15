package com.lakers.beanFactory;

import com.lakers.service.AccountService;
import com.lakers.uitl.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: panyusheng
 * @Date: 2020/5/15 17:31
 * 用于创建Service的代理对象的工厂
 * @Version 1.0
 */
public class BeanFactory {

    private AccountService accountService;

    private TransactionManager txManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public AccountService getAccountService() {
        return (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) {
                Object rtValue;
                try {
                    txManager.beginTransaction();
                    rtValue = method.invoke(accountService, args);
                    txManager.commit();
                    return rtValue;
                } catch (Exception e) {
                    txManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    txManager.release();
                }
            }
        });
    }

}
