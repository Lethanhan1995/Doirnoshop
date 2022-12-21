/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.dao;

import java.util.List;

import advance.dev.data.model.OrderDetail;

public interface OrderDetailDao {

    public void insert(OrderDetail orderdetail);

    public void update(OrderDetail orderdetail);

    public void delete(int orderdetailId);

    public OrderDetail find(int orderdetailId);

    public List<OrderDetail> findALL();

    public List<OrderDetail> findByOrder(int orderId);

}
