/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapp.managedbeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import myfirstapp.dao.ProductDAO;
import myfirstapp.modelo.Product;

/**
 *
 * @author desenvolvimento
 */
@Named(value = "productFace")
@SessionScoped
public class ProductFace implements Serializable {

  private ProductDAO prodDAO = new ProductDAO();
  private Product selectedProduct;
  private List<Product> products;
  
  
    public ProductFace() {
        System.out.println("Produtct Face has Created ! ");
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    
    
    public String startAddProduct(){
    
    selectedProduct = new Product();
    return "gotoAddNewProduct";
    }
    
    public String finishAddProduct() throws SQLException, ClassNotFoundException{
    prodDAO.add(selectedProduct);
    
    //Clear the Cache Products
    products = null;
    return "gotoListProducts";
    
    }
    
    public List<Product> getProducts() throws SQLException, ClassNotFoundException{
    
    if(products == null){
    products = prodDAO.getAllProducts();
    }
    return products;
    
    }
    
    public String startEditProduct(){
    return "gotoEditProduct";
    
    }
    
    public String finishEditProduct() throws SQLException, ClassNotFoundException{
     prodDAO.set(selectedProduct);
    
    //Clear the Cache Products
    products = null;
    return "gotoListProducts";
    
    }
    
    public String removeProduct() throws SQLException, ClassNotFoundException{
    
       prodDAO.delete(selectedProduct);
    
    //Clear the Cache Products
    products = null;
    return "gotoListProducts";
    }
}
