package com.company;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AcademyTest {
public Academy academy = new Academy();
@Ignore
 //   @Test
    void findMaximumElementMatrix() {
        int[][]arr = {
                {0,3,2,4},
                {2,3,5,5},
                {5,1,2,3}
        };
       int i = 1;
       int j = 2;
        String textCheck = academy.findMaximumElementMatrix(arr);
        assertEquals(i + " " + j,textCheck);
    }
    @Ignore
//    @Test
    void findMaximumElementMatrix1() {
        int[][]arr = {
                {-3,-2},
                {-2,-1}
        };
        int i = 1;
        int j = 1;
        String textCheck = academy.findMaximumElementMatrix(arr);
        assertEquals(i + " " + j,textCheck);
    }
// перевернуть массив
    @Ignore
//    @Test
    void reversArray() {
        int[][]array = {
                {0,0,9,9},
                {1,2,3,4},
                {5,6,7,8}
        };
        Academy.reverse(array);
        assertArrayEquals(new int[][]{{9,9,0,0},
                        {4,3,2,1},{8,7,6,5}},array);
    }
//@Ignore
//    @Test
//    void printRow() {
//        int[][]array = {
//                {0,1,0,1},
//                {1,1,0,1},
//                {1,0,0,1}
//
//        };
//        int check = Academy.printRow(array,2);
//        assertEquals(3,check);
//    }
    //@Ignore
 //   @Test
    void printRow1() {
        int[][]array = {
                {0,0,1,1,0,0},
                {1,1,0,0,1,0},
                {1,0,0,0,1,1}

        };
        int check = Academy.printRow(array,2);
        assertEquals(1,check);
    }
    //@Ignore
//    @Test
//    void printRow2() {
//        int[][]array = {
//                {1,1,1,1,0},
//                {0,0,0,0,1},
//                {1,0,1,1,1},
//                {0,1,0,0,0},
//                {1,1,1,0,0},
//                {1,1,1,1,0},
//                {1,0,1,0,0},
//                {0,1,1,0,0},
//                {0,1,0,0,0},
//                {1,0,1,0,0},
//                {1,1,1,1,0},
//
//        };
//        int check = Academy.printRow(array,1);
//        assertEquals(1,check);
//    }
//    @Test
//    void printRow3() {
//        int[][]array = {
//                {0,0,0,1,0,0},
//                {1,1,0,1,1,0},
//                {1,0,0,1,1,1}
//
//        };
//        int check = Academy.printRow(array,3);
//        assertEquals(1,check);
//    }
}