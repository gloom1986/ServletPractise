package com.ssergeev.servlet;

import com.ssergeev.entities.Item;
import com.ssergeev.services.ItemService;
import com.ssergeev.services.impl.ItemServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

    private ItemService itemService;
    private List<Item> cart;

    @Override
    public void init() throws ServletException {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        if (applicationContext != null) {
            itemService = applicationContext.getBean(ItemServiceImpl.class);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("userName")==null) {
            String userName = req.getParameter("userName");
            session.setAttribute("userName", userName);
        }
        if (session.getAttribute("items")==null) {
            List<Item> items = itemService.getAllItems();
            session.setAttribute("items", items);
        } else {
            if (req.getParameter("selectedItem") != null) {
                if (session.getAttribute("cart") == null) {
                    cart = new ArrayList<>();
                }
                String selectedItem = req.getParameter("selectedItem");
                String[] parsedSelectedItem = selectedItem.split(" ");
                int itemId = Integer.parseInt(parsedSelectedItem[0]);
                String itemName = parsedSelectedItem[1];
                double itemPrice = Double.parseDouble(parsedSelectedItem[2]);
                cart.add(new Item(itemId, itemName, itemPrice));
                session.setAttribute("cart", cart);
            }
            req.getRequestDispatcher("shop-page.jsp").forward(req, resp);
        }
    }
}
