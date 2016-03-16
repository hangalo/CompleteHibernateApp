/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapp.converter;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import myfirstapp.dao.ProductDAO;
import myfirstapp.modelo.Product;

/**
 *
 * @author desenvolvimento
 */
public class ProductConverter implements Converter {

    ProductDAO productDAO = new ProductDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer code = Integer.parseInt(value);
        try {
            return productDAO.getById(code);
        } catch (SQLException ex) {
            Logger.getLogger(ProductConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Product prod = (Product) value;
        return String.valueOf(prod.getCode());
    }

}
