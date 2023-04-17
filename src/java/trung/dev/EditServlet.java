package trung.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import trung.dev.dao.CategoryDao;
import trung.dev.dao.DatabaseDao;
import trung.dev.dao.ProductDao;
import trung.dev.dao.model.Product;
import trung.dev.dao.model.Category;

/**
 *
 * @author Administrator
 */
public class EditServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int productId = Integer.parseInt(request.getParameter("product_id"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);
        request.setAttribute("product", product);
        request.getRequestDispatcher("Edit.jsp").include(request, response);
//        response.sendRedirect("Edit.jsp");
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
        int productId = Integer.parseInt(request.getParameter("product_id"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);
        
        String name = request.getParameter("name");
   
        String description = request.getParameter("description");
        
        product.setName(name);
      
        product.setDescription(description);
        
        productDao.update(product);
        response.sendRedirect("NewServlet");
    }
}