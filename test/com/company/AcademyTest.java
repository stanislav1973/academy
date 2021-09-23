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
        String[][]arr =  Battleship.getArray();
        arr[0][0] = "O";
        arr[0][1] = "O";
        arr[0][2] = "O";
//String[][]a = Arrays.copyOf(arr,arr.length);

       String[][] test = TestsAcademy.checkShipSunk("A2",arr);
        System.out.print(Arrays.deepToString(arr));
        assertArrayEquals(test,arr);
    }

}