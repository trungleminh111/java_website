/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package trung.dev.admin.order;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import trung.dev.admin.BaseAdminServlet;
import trung.dev.dao.CategoryDao;
import trung.dev.dao.DatabaseDao;
import trung.dev.dao.OrderDao;
import trung.dev.dao.model.Category;
import trung.dev.dao.model.Order;

/**
 *
 * @author Administrator
 */
public class IndexOrderServlet extends BaseAdminServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        List<Order> orderlist = orderDao.findALL();

        request.setAttribute("orderlist", orderlist);
        request.getRequestDispatcher("admin/orders/index.jsp").include(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
