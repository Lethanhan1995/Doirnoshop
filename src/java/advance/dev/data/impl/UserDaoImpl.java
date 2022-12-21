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

import advance.dev.data.dao.UserDao;
import advance.dev.data.driver.MySQLDriver;
import advance.dev.data.model.User;

public class UserDaoImpl implements UserDao {

    @Override
    public void insert(User user) {
        // TODO Auto-generated method stub
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "INSERT INTO USERS(id, email, password, role, userscol) VALUES(NULL,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.email);
            stmt.setString(2, user.password);
            stmt.setString(3, user.role);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "UPDATE USERS SET EMAIL=?, PASSWORD=?, ROLE=?, WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.email);
            stmt.setString(2, user.password);
            stmt.setString(3, user.role);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void delete(int userId) {
        // TODO Auto-generated method stub
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            String sql = "DELETE FROM USERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, userId);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public User find(int userId) {
        // TODO Auto-generated method stub
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM USERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                return new User(id, email, password, role);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        List<User> userList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM USERS WHERE ID > ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                userList.add(new User(id ,email, password, role));
            }
        } catch (SQLException ex) {
        }

        return userList;
    }

    @Override
    public User find(String email, String password) {
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String role = rs.getString("role");

                return new User(id, email, password, role);
            }
        } catch (SQLException ex) {
            // TODO: handle exception
        }
        return null;
    }

}
