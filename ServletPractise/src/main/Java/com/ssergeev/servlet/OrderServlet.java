package com.ssergeev.servlet;

import com.ssergeev.entities.Item;
import com.ssergeev.entities.Order;
import com.ssergeev.entities.User;
import com.ssergeev.services.OrderService;
import com.ssergeev.services.impl.OrderServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private OrderService orderService;
    private List<Item> cart;

    @Override
    public void init() {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        if (applicationContext != null) {
            orderService = applicationContext.getBean(OrderServiceImpl.class);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (session.getAttribute("cart")==null) {
            if (orderService.isUserOrderExist(user.getId())){
                Order lastOrder = orderService.getLastUserOrderByUserId(user.getId());
                cart = orderItemService.getItemsByOrderId(lastOrder.getId());
            } else {
                resp.sendRedirect("/shop");
            }
        }
        else {
            cart = (List<Item>) session.getAttribute("cart");
            double totalPrice=0;
            for (Item item : cart) {
                totalPrice += item.getItemPrice();
                session.setAttribute("totalPrice", totalPrice);
            }
            int orderId = orderService.saveOrder(user.getId(), totalPrice);
            for (Item item: cart) {
                orderItemService.saveOrderItem(orderId,item.getId());
            }
        }
        req.getRequestDispatcher("order-page.jsp").forward(req, resp);
    }
}
