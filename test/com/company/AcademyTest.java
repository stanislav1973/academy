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
        String[][]arr = Battleship.getArray();
        arr[0][0] = "O";
        arr[1][0] = "O";
        arr[2][0] = "O";
        arr[3][0] = "O";

       String[][] test = TestsAcademy.checkShipSunk("A1",arr);
        System.out.print(Arrays.deepToString(arr));
        assertArrayEquals(test,arr);
    }

}