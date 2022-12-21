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

import advance.dev.data.dao.CategoryDao;
import advance.dev.data.driver.MySQLDriver;
import advance.dev.data.model.Category;

public class CategoryDaoImpl implements CategoryDao {


    @Override
    public void insert(Category category) {
        // TODO Auto-generated method stub
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "INSERT INTO CATEGORIES(id, name, description, img) VALUES(NULL,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.name);
            stmt.setString(2, category.description);
            stmt.setString(3, category.img);

            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void update(Category category) {
        // TODO Auto-generated method stub
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "UPDATE CATEGORIES SET NAME=?, DESCRIPTION=?, IMG=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.name);
            stmt.setString(2, category.description);
            stmt.setString(3, category.img);
            stmt.setInt(4, category.id);

            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void delete(int categoryId) {
        // TODO Auto-generated method stub
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            String sql = "DELETE FROM CATEGORIES WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, categoryId);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public Category find(int categoryId) {
        // TODO Auto-generated method stub
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM CATEGORIES WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String img = rs.getString("img");
                return new Category(id, name, description, img);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;

    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        List<Category> categoryList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM CATEGORIES";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String img = rs.getString("img");

                categoryList.add(new Category(id, name, description, img));
            }
        } catch (SQLException ex) {
        }

        return categoryList;
    }

   
}
