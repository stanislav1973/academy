package com.company;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AcademyTest {
    @Test
    void testLine(){
        String[][]arr = new String[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i < 1 && j < 2){
                    arr[i][j] = "X";
                }
                else arr[i][j] = "~";
            }
        }
       String test = TestsAcademy.checkShipSunk();
        assertEquals("YES",test);
    }

}