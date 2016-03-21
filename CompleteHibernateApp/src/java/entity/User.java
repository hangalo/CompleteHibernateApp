/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author desenvolvimento
 */
@Entity
@Table(name = "users")
public class User implements  Serializable{
    @Id
    @Column(name="id", nullable=false)
    private int id;
     @Column(name="name", nullable=false)
    private String name;
      @Column(name="login", nullable=false)
    private String login;
       @Column(name="password", nullable=false)
    private String password;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Product> products;
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
    public boolean isValidPassword(String passwordToTest){
    return passwordToTest.equals(password);
    }
}
