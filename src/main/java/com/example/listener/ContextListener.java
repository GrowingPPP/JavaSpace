package com.example.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@Component
@WebListener
public class ContextListener implements ServletContextListener,ServletRequestListener {
    public ContextListener(){

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听器被初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed监听器被销毁");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestDestroyed监听器被销毁");

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        //将所有request请求都携带上httpSession
        ((HttpServletRequest) servletRequestEvent.getServletRequest()).getSession();
        System.out.println("监听器被初始化，所有request带上httpsession");
    }
}
