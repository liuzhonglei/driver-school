package com.drivers.weixin.tool;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by xhuji on 2016/11/18.
 */
public class BigDecimalTest {

    public static void main(String[] args) {
       double i = Double.valueOf(1998)/100;
        System.out.printf("i:" + i);
    }

    @Test
    public void testEques(){
        System.out.println(BigDecimal.valueOf(11) == BigDecimal.valueOf(11));// false
        System.out.println(BigDecimal.valueOf(11).equals(BigDecimal.valueOf(11)));// true
        System.out.println(BigDecimal.valueOf(10) == BigDecimal.valueOf(10));// true
    }

    @Test
    public void testEquals(){

        System.out.println(new BigDecimal("0.0").equals(new BigDecimal("0.00")));// false
        System.out.println(new BigDecimal("0.0").hashCode() == (new BigDecimal("0.00")).hashCode());// false
        System.out.println(new BigDecimal("0.0").equals(new BigDecimal("0.0")));// true
        System.out.println(new BigDecimal("0.00").equals(new BigDecimal("0.00")));// true
        System.out.println(new BigDecimal("0.0").compareTo(new BigDecimal("0.00")) == 0);// true
    }
    @Test
    public void testZero(){
        try
        {
            BigDecimal.valueOf(1).divide(BigDecimal.ZERO);
        } catch (ArithmeticException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
