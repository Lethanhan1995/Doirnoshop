/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.model;

import advance.dev.data.dao.DatabaseDao;

public class OrderDetail {

    public int id;
    public int amount;
    public int product_id;
    public int order_id;
    public double price;

    public OrderDetail(int amount, int product_id, int order_id, double price) {
        this.amount = amount;
        this.product_id = product_id;
        this.order_id = order_id;
        this.price = price;
    }

    public OrderDetail(int id, int amount, int product_id, int order_id, double price) {
        this.id = id;
        this.amount = amount;
        this.product_id = product_id;
        this.order_id = order_id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return DatabaseDao.getInstance().getProductDao().find(product_id);
    }

    public Order getOrder() {
        return DatabaseDao.getInstance().getOrderDao().find(order_id);
    }

}
