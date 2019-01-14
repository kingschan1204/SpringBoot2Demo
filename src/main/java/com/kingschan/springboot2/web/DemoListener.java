package com.kingschan.springboot2.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 在spring boot中实现一个监听器
 * @author kings.chan
 * @create 2019-01-14 14:51
 **/
@Slf4j
@WebListener
public class DemoListener implements ServletContextListener{
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.error("contextDestroyed...web销毁");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.error("contextInitialized...web启动");

    }
}
