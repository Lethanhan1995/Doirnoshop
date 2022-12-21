/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package advance.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import advance.dev.data.dao.Database;
import advance.dev.data.dao.DatabaseDao;

/**
 *
 * @author Laptop QHD
 */
public class BaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        DatabaseDao.init(new Database());
    }

}
