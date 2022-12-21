/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import advance.dev.data.dao.ProductDao;
import advance.dev.data.driver.MySQLDriver;
import advance.dev.data.model.Product;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void insert(Product product) {
        // TODO Auto-generated method stub
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "INSERT INTO PRODUCTS(id, name, description, image, price, quantity, category_id) VALUES(NULL,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.name);
            stmt.setString(2, product.description);
            stmt.setString(3, product.image);
            stmt.setDouble(4, product.price);
            stmt.setString(5, product.quantity);
            stmt.setInt(6, product.categoryId);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void update(Product product) {
        // TODO Auto-generated method stub
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "UPDATE PRODUCTS SET NAME=?, DESCRIPTION=?, IMAGE=?, PRICE=?, QUANTITY =?, CATEGORY_ID =? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.name);
            stmt.setString(2, product.description);
            stmt.setString(3, product.image);
            stmt.setDouble(4, product.price);
            stmt.setString(5, product.quantity);
            stmt.setInt(6, product.categoryId);
            stmt.setInt(7, product.id);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void delete(int productId) {
        // TODO Auto-generated method stub
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            String sql = "DELETE FROM PRODUCTS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, productId);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public Product find(int productId) {
        // TODO Auto-generated method stub
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String quantity = rs.getString("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                return new Product(id, name, description, image, price, quantity, view, categoryId);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Product> findALL() {
        // TODO Auto-generated method stub
        List<Product> productList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM PRODUCTS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String quantity = rs.getString("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                productList.add(new Product(id, name, description, image, price, quantity, view, categoryId));
            }
        } catch (SQLException ex) {
        }

        return productList;
    }

    @Override
    public List<Product> findByName(String key) {
        List<Product> productList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM PRODUCTS WHERE NAME LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + key + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String quantity = rs.getString("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                productList.add(new Product(id, name, description, image, price, quantity, view, categoryId));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        List<Product> productList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY_ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String quantity = rs.getString("quantity");
                int view = rs.getInt("view");
                productList.add(new Product(id, name, description, image, price, quantity, view, categoryId));
            }
        } catch (SQLException ex) {
        }

        return productList;
    }

    @Override
    public List<Product> findByCategory(int categoryId, String orderBy, String order) {
        List<Product> productList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY_ID=? ORDER BY " + orderBy + " " + order;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
//            stmt.setString(2, orderBy);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String quantity = rs.getString("quantity");
                int view = rs.getInt("view");
                productList.add(new Product(id, name, description, image, price, quantity, view, categoryId));
            }
        } catch (SQLException ex) {
        }

        return productList;
    }

}
