package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcademyTest {
public Academy academy = new Academy();
    @Test
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
    @Test
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

    @Test
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
}