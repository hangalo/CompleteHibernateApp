/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapp.dao;

import java.util.List;
import myfirstapp.modelo.Product;
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
public class ProductDAOTest {

    public ProductDAOTest() {
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
     * Test of add method, of class ProductDAO.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Product prod = new Product();

        prod.setCode(9);
        prod.setName("Product Test");
        prod.setNumberOfItens(10);
        prod.setPrice(12);

        ProductDAO instance = new ProductDAO();
        boolean expResult = true;
        boolean result = instance.add(prod);
        assertEquals(expResult, result);

    }

    /**
     * Test of set method, of class ProductDAO.
     */
    @Test
    public void testSet() throws Exception {
        System.out.println("set");

        Product prod = new Product();
        ProductDAO instance = new ProductDAO();

        prod.setCode(9);
        prod.setName("Product Test Changed");
        prod.setNumberOfItens(10);
        prod.setPrice(12);

        boolean expResult = true;
        boolean result = instance.set(prod);

        assertEquals(expResult, result);

    }

    /**
     * Test of delete method, of class ProductDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Product prod = new Product();

        prod.setCode(9);
        prod.setName("Product Test Changed");
        prod.setNumberOfItens(10);
        prod.setPrice(12);
        ProductDAO instance = new ProductDAO();
        boolean expResult = true;
        boolean result = instance.delete(prod);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAllProducts method, of class ProductDAO.
     */
    @Test
    public void testGetAllProducts() throws Exception {
        System.out.println("getAllProducts");
        ProductDAO instance = new ProductDAO();

        List<Product> result = instance.getAllProducts();
        assertTrue(result.size() > 0);

    }

    /**
     * Test of getById method, of class ProductDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        int idProd = 2;
        ProductDAO instance = new ProductDAO();

        Product result = instance.getById(idProd);

        assertNotNull(result);
        assertEquals(idProd, result.getCode());

    }

}
