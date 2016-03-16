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
import myfirstapp.dao.LoginDAO;
import myfirstapp.modelo.Login;

/**
 *
 * @author desenvolvimento
 */
public class LoginConverter implements Converter{

    LoginDAO loginDAO = new LoginDAO();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer code = Integer.parseInt(value);
        try {
            return loginDAO.getById(code);
        } catch (SQLException ex) {
            Logger.getLogger(LoginConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Login login = (Login) value;
        return String.valueOf(login.getCode());
    }
    
}
