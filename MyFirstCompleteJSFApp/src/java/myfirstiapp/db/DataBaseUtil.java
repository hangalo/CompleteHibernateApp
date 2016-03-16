/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstiapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author desenvolvimento
 */
public class DataBaseUtil {

    private Connection cx = null;

    public DataBaseUtil() {
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (cx == null) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            cx = DriverManager.getConnection("jdbc:derby://localhost:1527/jsfexample", "jsf", "jsf");
        }
        return cx;
    }

    public Statement getStatement() throws SQLException, ClassNotFoundException {
        return getConnection().createStatement();
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
        return getConnection().prepareStatement(sql);

    }

    public void closeAll() throws SQLException {
        if (cx != null) {
            cx.close();
        }
    }
}
