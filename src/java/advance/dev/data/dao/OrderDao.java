/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.dao;

import java.util.List;

import advance.dev.data.model.Order;

public interface OrderDao {

    public void insert(Order order);

    public void update(Order order);

    public void delete(int orderId);

    public Order find(int orderId);
    
    public Order find(String code);

    public List<Order> findALL();
    
    public List<Order> findByStatus(String status);
    
    public int countOrderByDay(String date);

}
