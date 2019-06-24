package com.AAAAAA.pestcontrolproject.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSession {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybaitsConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
    }


    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        GetSession.sqlSessionFactory = sqlSessionFactory;
    }

    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
