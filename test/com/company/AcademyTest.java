package com.company;

import battleship.*;
import com.company.list.InputShips;
import com.company.list.Move;
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

       String[][] test = TestsAcademy.checkShipSunk("A1",arr);
        System.out.print(Arrays.deepToString(arr));
        assertArrayEquals(test,arr);
    }
@Test
    void testString() {
    String[][] array = new String[10][10];
    for (String[] s : array) {
        Arrays.fill(s, "~");
    }

    array[0][0] = "X"; array[9][0] = "X";
    array[0][1] = "X"; array[9][1] = "X";
    array[0][2] = "X"; array[9][2] = "X";
    array[0][3] = "X"; array[9][3] = "0";
    array[0][4] = "O"; array[9][4] = "X";
//    array[9][0] = "X"; array[0][0] = "X";
//    array[8][0] = "X"; array[1][0] = "X";
//    array[7][0] = "X"; array[2][0] = "X";
//    array[6][0] = "O"; array[3][0] = "O";
//    array[5][0] = "X"; array[4][0] = "X";


    Search search = new Search(9, 0);

     boolean b = search.isSearchHorizontal(search,array);
    System.out.print(b);
    boolean b1 = search.isSearchVertical(search,array);
    System.out.print(b1);


    }
    @Test
    void testEnum(){
        Search search = new Search(0,1);
        System.out.print(search.getMove());
    }
}