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
import myfirstapp.modelo.Product;
import myfirstiapp.db.DataBaseUtil;

/**
 *
 * @author desenvolvimento
 */
public class ProductDAO extends DataBaseUtil {

    public ProductDAO() {
        super();
    }

    public boolean add(Product prod) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getPreparedStatement("INSERT INTO JSF.PRODUCT VALUES(?,?,?,?)");
        ps.setInt(1, prod.getCode());
        ps.setString(2, prod.getName());
        ps.setInt(3, prod.getNumberOfItens());
        ps.setDouble(4, prod.getPrice());
        int toRturn = ps.executeUpdate();
        ps.close();
        return toRturn > 0;
    }

    public boolean set(Product prod) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getPreparedStatement("UPDATE JSF.PRODUCT SET  NAME=?, NUMBEROFITENS=?, PRICE=? WHERE CODE=?");
        ps.setString(1, prod.getName());
        ps.setInt(2, prod.getNumberOfItens());
        ps.setDouble(3, prod.getPrice());
        ps.setInt(4, prod.getCode());
        int toRturn = ps.executeUpdate();
        ps.close();
        return toRturn > 0;
    }

    public boolean delete(Product prod) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getPreparedStatement("DELETE FROM JSF.PRODUCT WHERE CODE=?");
        ps.setInt(1, prod.getCode());
        int toRturn = ps.executeUpdate();
        ps.close();
        return toRturn > 0;
    }

    public List<Product> getAllProducts() throws SQLException, ClassNotFoundException {
        List<Product> toReturn = new LinkedList<>();
        ResultSet rs = getStatement().executeQuery("SELECT * FROM JSF.PRODUCT");
        while (rs.next()) {
            Product prod = new Product();
            populateProd(prod, rs);

            toReturn.add(prod);
        }
        rs.close();
        return toReturn;
    }

    public Product getById(int idProd) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getPreparedStatement("SELECT * FROM JSF.PRODUCT WHERE CODE = ?");
        ps.setInt(1, idProd);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            return null;
        }
        Product toReturn = new Product();
        populateProd(toReturn, rs);
        rs.close();
        ps.close();
        return toReturn;
    }

    private void populateProd(Product prod, ResultSet rs) throws SQLException {
        prod.setCode(rs.getInt("CODE"));
        prod.setName(rs.getString("NAME"));
        prod.setNumberOfItens(rs.getInt("NUMBEROFITENS"));
        prod.setPrice(rs.getDouble("PRICE"));
    }
}
