/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package advance.dev.admin.product;

import advance.dev.admin.BaseAdminServlet;
import advance.dev.data.dao.CategoryDao;
import advance.dev.data.dao.DatabaseDao;
import advance.dev.data.dao.ProductDao;
import advance.dev.data.model.Category;
import advance.dev.data.model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Laptop QHD
 */
public class CreateProductServlet extends BaseAdminServlet {

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
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.findAll();

        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("admin/product/create.jsp").include(request, response);
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
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String quantity = request.getParameter("quantity");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(name, description, img, price, quantity, categoryId, categoryId);
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        productDao.insert(product);
        
        response.sendRedirect("IndexProductServlet");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
