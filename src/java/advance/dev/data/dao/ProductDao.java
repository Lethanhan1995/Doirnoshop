/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.dao;

import java.util.List;

import advance.dev.data.model.Product;

public interface ProductDao {

    public void insert(Product product);

    public void update(Product product);

    public void delete(int productId);

    public Product find(int productId);

    public List<Product> findALL();
    
    public List<Product> findByCategory(int categoryId);
    public List<Product> findByCategory(int categoryId, String orderBy, String order);
    
    public List<Product> findByName(String name);

}
