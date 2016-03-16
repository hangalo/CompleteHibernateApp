/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapp.dao;

import java.util.List;
import myfirstapp.modelo.Login;
import myfirstapp.modelo.Product;
import myfirstapp.modelo.Sales;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author desenvolvimento
 */
public class SalesDAOTest {

    public SalesDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class SalesDAO.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Sales sale = new Sales();
        ProductDAO prodDAO = new ProductDAO();
        LoginDAO vendorDAO = new LoginDAO();
        SalesDAO instance = new SalesDAO();

        sale.setCode(100);
        sale.setProduct(prodDAO.getById(1));
        sale.setAddress("Address Test 1");
        sale.setVendor(vendorDAO.getById(1));

        boolean expResult = true;
        boolean result = instance.add(sale);
        assertEquals(expResult, result);

    }

    /**
     * Test of delete method, of class SalesDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Sales sale = new Sales();
        ProductDAO prodDAO = new ProductDAO();
        LoginDAO vendorDAO = new LoginDAO();
        sale.setCode(100);
        sale.setProduct(prodDAO.getById(1));
        sale.setAddress("Address Test 1");
        sale.setVendor(vendorDAO.getById(1));
        SalesDAO instance = new SalesDAO();
        boolean expResult = true;
        boolean result = instance.delete(sale);
        assertEquals(expResult, result);

    }

    /**
     * Test of getSales method, of class SalesDAO.
     */
    @Test
    public void testGetSales() throws Exception {
        System.out.println("getSales");
        SalesDAO instance = new SalesDAO();

        List<Sales> result = instance.getSales();
        assertNotNull(result);

    }

}
