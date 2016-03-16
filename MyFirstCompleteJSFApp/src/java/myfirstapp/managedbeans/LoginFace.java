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
import javax.faces.context.FacesContext;
import myfirstapp.dao.LoginDAO;

/**
 *
 * @author desenvolvimento
 */
@Named(value = "loginFace")
@SessionScoped
public class LoginFace implements Serializable {
    
    LoginDAO loginDAO = new LoginDAO();
    
    private String user;
    private String password;

    /**
     * Creates a new instance of LoginFace
     */
    public LoginFace() {
       
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String doLogin() throws SQLException, ClassNotFoundException{
     boolean validated = loginDAO.validadeUser(user, password);
        if(validated){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userlogged", validated);
        return "gotoMain";
        }else{
        
        return "gotoLoginInvalid";
        }
    
    }
    
}
