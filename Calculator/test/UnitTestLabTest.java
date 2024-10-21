/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class UnitTestLabTest {
    
    public UnitTestLabTest() {
    }
    
    private UnitTestLab lab;
    private ByteArrayOutputStream out;
    private Appender appender;

    @Before
    public void setUp() {
        lab = new UnitTestLab();
        out = new ByteArrayOutputStream();
        appender = new WriterAppender(new SimpleLayout(), out);
        Logger.getLogger(UnitTestLab.class).addAppender(appender);
    }

    @After
    public void tearDown() {
        Logger.getLogger(UnitTestLab.class).removeAppender(appender);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of logMsg method, of class UnitTestLab.
     */
    
    @Test
    public void testCalcFactorialValidInput() {
        assertEquals(new BigInteger("120"), lab.calcFactorial(5));  // 5! = 120
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcFactorialInvalidInput() {
        lab.calcFactorial(0);  // Expect IllegalArgumentException
    }
    
        
    // Test calcFactorial with a valid input but expect timeout if it takes too long
    @Test(timeout = 1000)  // Timeout set to 1000 milliseconds (1 second)
    public void testCalcFactorialTimeout() {
        lab.calcFactorial(100000);  // Test with a large number
    }
    
    @Test
    public void testPrintFactorial_ValidInput() {
        lab.printFactorial(5); // Gọi hàm với tham số hợp lệ

        String logMsg = out.toString();
        assertTrue(logMsg.contains("number=5")); // Kiểm tra log message cho số đầu vào
        assertTrue(logMsg.contains("factorial=120")); // Kiểm tra log message cho giá trị factorial
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintFactorial_InvalidInput() {
        lab.printFactorial(0); // Gọi hàm với tham số không hợp lệ
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintFactorial_NegativeInput() {
        lab.printFactorial(-5); // Gọi hàm với tham số âm
    }

    @Test
    public void testCalcExtraFactorialValid() {
        assertEquals(24, lab.calcExtraFactorial(4, 1));  // 4! = 24
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcExtraFactorialInvalidInput() {
        lab.calcExtraFactorial(-11, 1);  // Expect IllegalArgumentException
    }

}
