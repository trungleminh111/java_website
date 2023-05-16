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
import java.util.List;
import trung.dev.dao.model.OrderDetailSession;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        String promoCode = request.getParameter("promoCode");

        // Kiểm tra xem mã giảm giá có hợp lệ hay không
        if (isValidPromoCode(promoCode)) {
            // Áp dụng giảm giá cho giỏ hàng
            HttpSession session = request.getSession();
            List<OrderDetailSession> cart = (List<OrderDetailSession>) session.getAttribute("cart");
            if (cart != null) {
                for (OrderDetailSession ods : cart) {
                    ods.setProductPrice(applyPromoCode((int) ods.getProductPrice(), promoCode));
                }
                response.sendRedirect("CartServlet");
            }
        }
    }
// Hàm kiểm tra mã giảm giá có hợp lệ hay không

    private boolean isValidPromoCode(String promoCode) {
        // Kiểm tra xem mã giảm giá có nằm trong danh sách mã giảm giá hợp lệ không
        List<String> validPromoCodes = Arrays.asList("SUMMER10", "FALL15", "WINTER20");
        return validPromoCodes.contains(promoCode);
    }

// Hàm áp dụng giảm giá cho giá sản phẩm
    private float applyPromoCode(int price, String promoCode) {
        // Nếu mã giảm giá hợp lệ, áp dụng giảm giá 10%, 15% hoặc 20% tương ứng
        if (promoCode.equals("SUMMER10")) {
            return price * 0.9f;
        } else if (promoCode.equals("FALL15")) {
            return price * 0.85f;
        } else if (promoCode.equals("WINTER20")) {
            return price * 0.8f;
        } else {
            // Nếu không có mã giảm giá hoặc mã không hợp lệ, trả về giá gốc
            return price;
        }
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
