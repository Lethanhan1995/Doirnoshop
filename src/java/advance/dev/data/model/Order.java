/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.model;

import advance.dev.data.dao.Database;

public class Order {

    public int id;
    public String code;
    public String description;
    public String status;
    public int userId;

    public Order(int id, String code, String description, String status, int userId) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    public Order(String code, String description, String status, int userId) {
        this.code = code;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser(){
    return Database.getInstance().getUserDao().find(userId);
    }

    
}
 
