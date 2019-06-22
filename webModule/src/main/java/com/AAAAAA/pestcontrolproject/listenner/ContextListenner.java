package com.AAAAAA.pestcontrolproject.listenner;

import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;

/**
 * 上下文监听器
 */
public class ContextListenner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //项目完成时再添加，直接添加不利于项目调试
//
//        try {
//            //tomcat初始化时加载数据库配置文件
//           InputStream in = Resources.getResourceAsStream("mybaitsConfig.xml");
//            //利用配置文件返回数据库连接工厂类
//            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
//            GetSession.setSqlSessionFactory(sqlSessionFactory);
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
