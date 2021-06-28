package com.company;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AcademyTest {
    @Test
    void testTest(){
   String in = AddShips.test("f1");
   assertEquals("f",in);
}
    @Test
    void testTest1(){
        int in = AddShips.test1("f10");
        assertEquals(10,in);
    }
    @Test
    void testTest2(){
        int in = AddShips.test1("f1");
        assertEquals(1,in);
    }
}