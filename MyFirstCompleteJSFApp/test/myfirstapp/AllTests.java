/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapp;

import myfirstapp.dao.LoginDAOTest;
import myfirstapp.dao.ProductDAOTest;
import myfirstapp.dao.SalesDAOTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author desenvolvimento
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({LoginDAOTest.class, ProductDAOTest.class,SalesDAOTest.class})
public class AllTests {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
