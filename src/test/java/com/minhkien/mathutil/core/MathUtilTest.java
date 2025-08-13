/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.minhkien.mathutil.core;

import static com.minhkien.mathutil.core.MathUtil.getFactorial;
import org.junit.jupiter.api.function.Executable;
//import static là dành riêng cho những hàm static
//gọi hàm bỏ qua tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author PC
 */
public class MathUtilTest {
    
    //DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    //vào trong câu lệnh kiểm thử
    
    //chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][] {
            {1, 1},
            {2, 2},
            {6, 720}
        };
    }
    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp datam ngầm định thứ tự
    //của các phần tử mảng, map vào tham số hàm
    public void testGetFactoryalGivenRightArgReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    
    
//    @Test 
//    public void testGetFactoryalGivenRightArgReturnWell() {
//        assertEquals(24, getFactorial(4));
//    }
    
    @Test
    //bắt ngoại lệ khi đưa data cà chớn!!!
    //@Test(expected - tên ngoại lệ.class) JUnit hoy, JUnit hok xài vậy!!!
    
    public void testGetFactorialGivenWrongArgThrowException() {
        //xài biểu thức Lambda
        //hamf nhận vào tham số thứ 2 là 1 cái object/có code implement cái
        //functional interface tên là Exccutable - có 1 hàm duy nhất ko code
        //tên là excute()
        //chơi chậm
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };

//        Executable exObject = () ->  getFactorial(-5);
        
        assertThrows(IllegalArgumentException.class, () ->  getFactorial(-5));
    }
            
}
