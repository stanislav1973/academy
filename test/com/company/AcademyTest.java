package com.company;

import battleship.*;
import com.company.list.InputShips;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AcademyTest {
    String[][]arr = new String[5][5];
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
@Test
    void testString() {

}
}