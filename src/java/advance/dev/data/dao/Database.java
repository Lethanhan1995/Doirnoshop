/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.dao;

import advance.dev.data.impl.CategoryDaoImpl;
import advance.dev.data.impl.OrderDaoImpl;
import advance.dev.data.impl.OrderDetailDaoImpl;
import advance.dev.data.impl.ProductDaoImpl;
import advance.dev.data.impl.UserDaoImpl;

public class Database extends DatabaseDao {

    @Override
    public UserDao getUserDao() {
        // TODO Auto-generated method stub
        return new UserDaoImpl();
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoImpl();
    }
    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImpl();
    }

    @Override
    public OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }

    @Override
    public OrderDetailDao getOrderDetailDao() {
        return new OrderDetailDaoImpl();
    }

}