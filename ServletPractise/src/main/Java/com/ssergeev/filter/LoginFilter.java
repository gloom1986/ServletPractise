package com.ssergeev.filter;

import com.ssergeev.entities.User;
import com.ssergeev.services.UserService;
import com.ssergeev.services.impl.UserServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/shop", "/order"})
public class LoginFilter extends HttpFilter {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        if (applicationContext != null) {
            userService = applicationContext.getBean(UserServiceImpl.class);
        }
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (req.getParameter("checkBox") != null) {
            session.setAttribute("checkBox", "on");
            chain.doFilter(req, res);
        } else {
            if (session.getAttribute("checkBox") != null) {
                chain.doFilter(req, res);
            }
            res.sendRedirect("");
        }
        if (session.getAttribute("user") == null) {
            if (!userService.isLoginExist(req.getParameter("userName"))) {
                userService.saveUser(req.getParameter("userName"));
            }
            User user = userService.getUserByLogin(req.getParameter("userName"));
            session.setAttribute("user", user);
            chain.doFilter(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
