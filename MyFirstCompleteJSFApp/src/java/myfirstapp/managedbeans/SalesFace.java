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
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;
import myfirstapp.dao.LoginDAO;
import myfirstapp.dao.ProductDAO;
import myfirstapp.dao.SalesDAO;
import myfirstapp.modelo.Login;
import myfirstapp.modelo.Product;
import myfirstapp.modelo.Sales;

/**
 *
 * @author desenvolvimento
 */
@Named(value = "salesFace")
@SessionScoped
public class SalesFace implements Serializable {

    SalesDAO salesDAO = new SalesDAO();
    ProductDAO productDAO = new ProductDAO();
    LoginDAO loginDAO = new LoginDAO();
    Sales selectedSale;
    List<Sales> sales;

    public SalesFace() {
        System.out.println("Sales Face has Created !");
    }

    public Sales getSelectedSale() {
        return selectedSale;
    }

    public void setSelectedSale(Sales selectedSale) {
        this.selectedSale = selectedSale;
    }

    
    
    public List<SelectItem> getProducts() throws SQLException, ClassNotFoundException{
    List<SelectItem> toReturn = new LinkedList<>();
    for(Product prod: productDAO.getAllProducts()){
    toReturn.add(new SelectItem(prod,prod.getName()));
    }
    
    return  toReturn;
    }
    
    
    public List<SelectItem> getVendors() throws SQLException, ClassNotFoundException{
      List<SelectItem> toReturn = new LinkedList<>();
    for(Login login: loginDAO.getUsers()){
    toReturn.add(new SelectItem(login,login.getName()));
    }
    return toReturn;
    }
    public String startAddNewSale() {
        selectedSale = new Sales();
        return "gotoAddNewSale";
    }

    public String finishAddNewSale() throws SQLException, ClassNotFoundException {
        salesDAO.add(selectedSale);
        //Clean the Cache Sales
        sales = null;
        return "gotoListSales";
    }

    public String deleteSale() throws SQLException, ClassNotFoundException {
        salesDAO.delete(selectedSale);
        //Clean the Cache Sales
        sales = null;
        return "gotoListSales";

    }
    
    public String viewSelectedSale(){
    
    return "gotoViewSelectedSales";
    }

    public List<Sales> getSales() throws SQLException, ClassNotFoundException {

        if (sales == null) {
            sales = salesDAO.getSales();
        }
        return sales;
    }
}
