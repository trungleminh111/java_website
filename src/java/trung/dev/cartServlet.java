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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import trung.dev.dao.DatabaseDao;
import trung.dev.dao.ProductDao;
import trung.dev.dao.model.OrderDetailSesstion;
import trung.dev.dao.model.Product;

/**
 *
 * @author Administrator
 */
public class cartServlet extends BaseServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<OrderDetailSesstion> cart = (List<OrderDetailSesstion>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }
        request.setAttribute("cart", cart);
        request.setAttribute("total", total(cart));
        request.getRequestDispatcher("cart.jsp").include(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");
        switch (action) {
            case "create":
                createOrder(request, response);
                break;
            case "update":
                updateOrder(request, response);
                break;
            
            default:
                throw new AssertionError();
        }
    }

    private OrderDetailSesstion find(List<OrderDetailSesstion> cart, int productId) {
        for (OrderDetailSesstion ods : cart) {
            if (ods.getProductId() == productId) {
                return ods;
            }
        }
        return null;
    }
   private void updateCart(HttpSession session, List<OrderDetailSesstion> cart, OrderDetailSesstion find, int value) {
        for (OrderDetailSesstion ods : cart) {
            if (ods.getProductId() == find.getProductId()) {
                ods.setQuantity(value);
                if (ods.getQuantity() < 1) {
                    ods.setQuantity(1);
                }
            }
        }
        session.setAttribute("cart", cart);
    }
    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("product_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);

        OrderDetailSesstion orderDetailSesstion = new OrderDetailSesstion(productId, product.getName(), product.getImg(), quantity, product.getPrice());
        List<OrderDetailSesstion> cart = (List<OrderDetailSesstion>) session.getAttribute("cart");

        if (cart == null) {
//            tao session
            cart = new ArrayList<>();
            cart.add(orderDetailSesstion);

        } else {
//            tim kiem san pham da co trong gio hang chua
            OrderDetailSesstion find = find(cart, orderDetailSesstion.getProductId());
            if (find == null) {
// san pham chua co trong gio hang
                cart.add(orderDetailSesstion);

            } else {
                // san pham da co thuc hien cap nhat so luong
                updateCart(session, cart, find, find.getQuantity() + quantity);
            }
        }
        session.setAttribute("cart", cart);
        response.sendRedirect("cartServlet");
    }
     private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("product_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        List<OrderDetailSesstion> cart = (List<OrderDetailSesstion>) session.getAttribute("cart");
        OrderDetailSesstion find = find(cart, productId);

        updateCart(session, cart, find, find.getQuantity() + quantity);
        response.sendRedirect("cartServlet");
    }

    private int total(List<OrderDetailSesstion> cart) {
        int sum = 0;
        for (OrderDetailSesstion ods : cart) {
            sum += ods.getProductPrice() * ods.getQuantity();
        }
        return sum;
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
