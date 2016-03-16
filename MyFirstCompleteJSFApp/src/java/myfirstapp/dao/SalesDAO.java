/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import myfirstapp.modelo.Sales;
import myfirstiapp.db.DataBaseUtil;

/**
 *
 * @author desenvolvimento
 */
public class SalesDAO extends DataBaseUtil {

    private ProductDAO productDAO = new ProductDAO();
    private LoginDAO loginDAO = new LoginDAO();

    public SalesDAO() {
        super();
    }

    public boolean add(Sales sale) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getPreparedStatement("INSERT INTO JSF.SALES VALUES(?,?,?,?,?)");

        ps.setInt(1, sale.getCode());
        ps.setInt(2, sale.getProduct().getCode());
        ps.setString(3, sale.getAddress());
        ps.setInt(4, sale.getVendor().getCode());
        ps.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        int toRturn = ps.executeUpdate();
        ps.close();
        return toRturn > 0;
    }

    public boolean delete(Sales sale) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getPreparedStatement("DELETE FROM JSF.SALES WHERE CODE=?");
        ps.setInt(1, sale.getCode());
        int toRturn = ps.executeUpdate();
        ps.close();
        return toRturn > 0;
    }

    public List<Sales> getSales() throws SQLException, ClassNotFoundException {
        List<Sales> toReturn = new LinkedList<>();
        ResultSet rs = getStatement().executeQuery("SELECT * FROM JSF.SALES");
        while (rs.next()) {
            Sales sl = new Sales();
            populateSalesInfo(sl, rs);
            toReturn.add(sl);
        }

        return toReturn;
    }

    private void populateSalesInfo(Sales sl, ResultSet rs) throws SQLException, ClassNotFoundException {
        sl.setCode(rs.getInt("CODE"));
        sl.setProduct(productDAO.getById(rs.getInt("PRODUCT")));
        sl.setAddress(rs.getString("ADDRESS"));
        sl.setVendor(loginDAO.getById(rs.getInt("VENDOR")));
        sl.setDate(rs.getDate("DATE"));
    }
}
