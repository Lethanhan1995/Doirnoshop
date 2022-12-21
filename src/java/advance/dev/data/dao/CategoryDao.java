/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.dao;

import java.util.List;
import advance.dev.data.model.Category;

public interface CategoryDao {

    public void insert(Category category);

    public void update(Category category);

    public void delete(int categoryId);

    public Category find(int categoryId);

    public List<Category> findAll();

}
