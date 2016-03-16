/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import myfirstapp.modelo.Login;
import myfirstiapp.db.DataBaseUtil;

/**
 *
 * @author desenvolvimento
 */
public class LoginDAO extends DataBaseUtil {

    public LoginDAO() {
        super();
    }

    public boolean validadeUser(String username, String password) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = getPreparedStatement("SELECT * FROM JSF.LOGIN WHERE USERNAME =? AND PASSWORD =?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        boolean toReturn = rs.next();
        rs.close();
        ps.close();
        return toReturn;

    }

    public List<Login> getUsers() throws SQLException, ClassNotFoundException {
        List<Login> toReturn = new LinkedList<>();
        ResultSet rs = getStatement().executeQuery("SELECT * FROM JSF.LOGIN");
        while (rs.next()) {
            Login lg = new Login();
            populateUserInfo(lg, rs);
            toReturn.add(lg);
        }
        return toReturn;
    }

    public Login getById(int userId) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getPreparedStatement("SELECT * FROM JSF.LOGIN WHERE CODE=?");
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        Login toReturn = null;
        while (rs.next()) {
            toReturn = new Login();
            populateUserInfo(toReturn, rs);
        }

        rs.close();
        ps.close();
        return toReturn;
    }

    private void populateUserInfo(Login toReturn, ResultSet rs) throws SQLException {
        toReturn.setCode(rs.getInt("CODE"));
        toReturn.setName(rs.getString("NAME"));
        toReturn.setUsername(rs.getString("USERNAME"));
        toReturn.setPassword(rs.getString("PASSWORD"));
    }
}
