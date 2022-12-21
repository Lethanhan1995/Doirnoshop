/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.dao;

import java.util.List;

import advance.dev.data.model.User;

public interface UserDao {

    public void insert(User user);

    public void update(User user);

    public void delete(int userId);

    public User find(int userId);
    
    public User find(String email, String password);

    public List<User> findAll();
}
