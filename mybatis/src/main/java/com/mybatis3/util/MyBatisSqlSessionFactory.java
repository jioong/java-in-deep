package com.mybatis3.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jioong on 17-9-28.
 */
public class MyBatisSqlSessionFactory {

    private static SqlSessionFactory factory;

    public static SqlSessionFactory getSqlSessionFactory() {

        if (factory == null) {
            synchronized (MyBatisSqlSessionFactory.class) {
                if (factory == null) {
                    try {
                        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
                        factory = new SqlSessionFactoryBuilder().build(is);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return factory;
    }
}
