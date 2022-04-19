package org.example;

import com.atguigu.junit.Calculator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {
    private static Calculator calculator = new Calculator();
    @Before
    public void setUp() throws Exception {
        calculator.clear();
    }


    public void testAdd() {
        calculator.add(2);
        calculator.add(3);
        assertEquals(5,calculator.getResult());
    }

    @Test
    public void testSubstract() {
        calculator.add(10);
        calculator.substract(2);
        assertEquals(8, calculator.getResult());
    }
    //@Ignore("Multiply() Not yet implemented")
    @Test
    public  void testMultiply() {
        calculator.squareRoot(3);
    }

    @Test
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());
    }

}

