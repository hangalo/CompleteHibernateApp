/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapp.dao;

import java.util.List;
import myfirstapp.modelo.Login;
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
public class LoginDAOTest {
    
    public LoginDAOTest() {
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
     * Test of validadeUser method, of class LoginDAO.
     */
    @Test
    public void testValidadeUser() throws Exception {
        System.out.println("validadeUser");
        String username = "hangalo";
        String password = "123";
        LoginDAO instance = new LoginDAO();
        boolean expResult = true;
        boolean result = instance.validadeUser(username, password);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of getUsers method, of class LoginDAO.
     */
    @Test
    public void testGetUsers() throws Exception {
        System.out.println("getUsers");
        LoginDAO instance = new LoginDAO();
         List<Login> result = instance.getUsers();
      
    }

    /**
     * Test of getById method, of class LoginDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        int userId = 2;
        LoginDAO instance = new LoginDAO();
        Login expResult = null;
        Login result = instance.getById(userId);
        assertNotNull(result);
       
    }
    
}
