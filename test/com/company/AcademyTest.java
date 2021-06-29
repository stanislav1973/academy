package com.company;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AcademyTest {
    @Ignore
    //@Test
    void testTest(){
   String in = AddShips.test("f100hlkjh");
   assertEquals("j",in);
}
    @Ignore
    //@Test
    void testTest1(){
        int in = AddShips.test1("f101h10");
        assertEquals(10,in);
    }
    //@Test
    @Ignore
    void testTest2(){
        int in = AddShips.test1("f1");
        assertEquals(1,in);
    }
    //@Test
    @Ignore
    void testTest3(){
        int in = AddShips.test2(10 ,20);
        assertEquals(10,in);
    }
    @Test
    void testArray(){
        String[][] array = new String[10][10];

        String[][]arrayTest = new String[10][10];
        for (int i = 0; i < arrayTest.length; i++) {
            for (int j = 0; j < arrayTest[i].length; j++) {
                arrayTest[i][j] = "~";
            }
        }
        String [][] arr = AddShips.testArray(array);
        assertArrayEquals(arrayTest,arr);
    }
}