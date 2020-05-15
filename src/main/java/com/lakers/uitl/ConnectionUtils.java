package com.lakers.uitl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: panyusheng
 * @Date: 2020/5/15 15:40
 * 数据库连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 * @Version 1.0
 */
@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;


    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        //1. 先从ThreadLocal上获取
        Connection conn = tl.get();
        //2. 判断当前线程上是否有连接
        if (conn == null) {
            try {
                //3. 从数据源中获取一个连接，并存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    /**
     * 把连接从线程中解绑
     * @return
     */
    public void removeConnection() {
        tl.remove();
    }

}
