/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package trung.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import trung.dev.dao.DatabaseDao;
import trung.dev.dao.ProductDao;
import trung.dev.dao.model.Product;

/**
 *
 * @author Administrator
 */
public class ShopServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        String sortOrder = request.getParameter("sortOrder");
        List<Product> productList = productDao.getSortedProducts(sortOrder);

        request.setAttribute("productList", productList);
        request.getRequestDispatcher("shop.jsp").include(request, response);
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
