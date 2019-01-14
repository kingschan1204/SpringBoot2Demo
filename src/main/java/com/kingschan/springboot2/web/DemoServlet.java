package com.kingschan.springboot2.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在spring boot 中定义一个标准的servlet
 * @author kings.chan
 * @create 2019-01-14 14:35
 **/
@WebServlet(urlPatterns = "/web/servlet",
        initParams={
                @WebInitParam(name="message",value="hello I'm from diy servlet !")
        })
public class DemoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(this.getInitParameter("message"));
    }
}
