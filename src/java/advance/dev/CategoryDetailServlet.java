/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package advance.dev;

import advance.dev.data.dao.CategoryDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import advance.dev.data.dao.DatabaseDao;
import advance.dev.data.dao.ProductDao;
import advance.dev.data.model.Category;
import advance.dev.data.model.Product;

/**
 *
 * @author Admin
 */
public class CategoryDetailServlet extends BaseServlet {

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
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.findAll();
        
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = null;
        String orderBy = request.getParameter("orderBy");
        if(orderBy == null) orderBy = "name";
        
        String order = request.getParameter("order");
        if(order == null) order = "asc";
        
        productList = productDao.findByCategory(categoryId, orderBy, order);
        
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("productList", productList);
        request.setAttribute("categoryId", categoryId);
        request.setAttribute("orderBy", orderBy);
        request.setAttribute("order", order);
        
        request.getRequestDispatcher("category-detail.jsp").include(request, response);
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
    }

}
