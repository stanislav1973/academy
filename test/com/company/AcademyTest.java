package com.company;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AcademyTest {
    //@Test
    void testTest(){
   String in = AddShips.test("f100hlkjh");
   assertEquals("j",in);
}

    //@Test
    void testTest1(){
        int in = AddShips.test1("f101h10");
        assertEquals(10,in);
    }
    //@Test
    void testTest2(){
        int in = AddShips.test1("f1");
        assertEquals(1,in);
    }
    //@Test
    void testTest3(){
        int in = AddShips.test2(0 ,9);
        assertEquals(10,in);
    }
    //@Test
    void testArray(){
        boolean [][] array = new boolean[10][10];
        //String arr = AddShips.testArray(0,4,0,1,array);
        //assertEquals("false",arr);
    }
    @Test
    void testInputTextInt2(){
        int count = 1; // two pipes
        int lengthShipNumber = TestsAcademy.lengthShips(0,1);
        int s = TestsAcademy.testInputTextInt(lengthShipNumber);
        assertEquals(1, s);
        String s1 = TestsAcademy.testInputTextString(s -1, count);
        assertEquals("Destroyer", s1);
    }
    @Test
    void testInputTextInt3_1(){// three tube
        int count = 2;
        int lengthShipNumber = TestsAcademy.lengthShips( 0 ,2);
        int s = TestsAcademy.testInputTextInt(lengthShipNumber);
        assertEquals(2, lengthShipNumber);
        String s1 = TestsAcademy.testInputTextString(s - 1 , count);
        assertEquals("Destroyer", s1);
    }
    @Test
    void testInputTextInt3(){ // three pipes
        int count = 3;
        int lengthShipNumber = TestsAcademy.lengthShips(0,2);
        int s = TestsAcademy.testInputTextInt(lengthShipNumber);
        assertEquals(2, lengthShipNumber);
        String s1 = TestsAcademy.testInputTextString(s - 1 , count);
        assertEquals("Cruiser", s1);
    }
    @Test
    void testInputTextInt4(){ // four pipes
        int count = 4;
        int lengthShipNumber = TestsAcademy.lengthShips(0 ,3);
        int s = TestsAcademy.testInputTextInt(lengthShipNumber);
        assertEquals(3, s);
        String s1 = TestsAcademy.testInputTextString(s - 1, count);
        assertEquals("Submarines", s1);
    }
    @Test
    void testInputTextInt5(){
        int count = 5; //fife pipes
        int lengthShipNumber = TestsAcademy.lengthShips(0 ,4);
        int s = TestsAcademy.testInputTextInt(lengthShipNumber);
        assertEquals(4, s);
        String s1 = TestsAcademy.testInputTextString(s - 1, count);
        assertEquals("Battleship", s1);
    }
    @Test
    void testLengthShips(){
        int i = TestsAcademy.lengthShips(0, 2);
        assertEquals(2,i);
    }

}