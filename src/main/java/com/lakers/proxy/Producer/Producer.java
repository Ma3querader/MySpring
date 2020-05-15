package com.lakers.proxy.Producer;

/**
 * @Author: panyusheng
 * @Date: 2020/5/15 17:02
 * 生产者
 * @Version 1.0
 */
public class Producer implements IProducer {

    public void saleProduct(float money) {
        System.out.println("生产了一个产品，价钱为:" + money);
    }
}
