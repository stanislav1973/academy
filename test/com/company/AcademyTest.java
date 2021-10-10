package com.company;

import battleship.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.annotation.Target;
import java.util.Arrays;

public class AcademyTest {
       static String[][] array = new String[10][10];

    @BeforeAll
    public static void array() {
        array = new String[10][10];
        for (String[] s : array) {
            Arrays.fill(s, "~");
        }
    }

    @Test
   public void testHorizontal() {
        array[0][0] = "X";
        array[0][1] = "X";
        array[0][2] = "X";
        Search search = new Search(0, 0);
        boolean b = search.isSearchHorizontal(search, array);
        boolean b1 = search.isSearchVertical(search, array);
        System.out.println(b + " " + b1);
    }

    @Test
    void testHorizontal1() {
        array[0][9] = "X";
        array[0][8] = "X";
        array[0][7] = "X";
        Search search = new Search(0, 9);
        boolean b = search.isSearchHorizontal(search, array);
        boolean b1 = search.isSearchVertical(search, array);
        System.out.println(b + " " + b1);
    }
    @Test
    void testHorizontal2() {
        array[9][9] = "X";
        array[9][8] = "X";
        array[9][7] = "X";
        Search search = new Search(9, 9);
        boolean b = search.isSearchHorizontal(search, array);
        boolean b1 = search.isSearchVertical(search, array);
        System.out.println(b + " " + b1);
    }
    @Test
    void testHorizontal3() {
        array[9][0] = "X";
        array[9][1] = "O";
        array[9][2] = "X";
        Search search = new Search(9, 0);
        boolean b = search.isSearchHorizontal(search, array);
        boolean b1 = search.isSearchVertical(search, array);
        System.out.println(b + " " + b1);
    }
    @Test
    void testVertical() {
        array[1][0] = "X";
        array[0][0] = "X";
        array[2][0] = "O";
        Search search = new Search(1, 0);
        boolean b = search.isSearchHorizontal(search, array);
        boolean b1 = search.isSearchVertical(search, array);
        System.out.println(b + " " + b1);
    }
    @Test
    void testVertical1() {
        array[7][0] = "X";
        array[8][0] = "X";
        array[9][0] = "X";
        Search search = new Search(9, 0);
        boolean b = search.isSearchHorizontal(search, array);
        boolean b1 = search.isSearchVertical(search, array);
        System.out.println(b + " " + b1);
    }
    @Test
    void testVertical2() {
        array[0][9] = "X";
        array[1][9] = "X";
        array[2][9] = "X";
        array[3][9] = "X";
        array[4][9] = "O";
        Search search = new Search(0, 9);
        boolean b = search.isSearchHorizontal(search, array);
        boolean b1 = search.isSearchVertical(search, array);
        System.out.println(b + " " + b1);
    }
    @Test
    void testVertical3() {
        array[9][9] = "X";
        array[8][9] = "X";
        array[7][9] = "X";
        array[6][9] = "X";

        Search search = new Search(9, 9);
        boolean b = search.isSearchHorizontal(search, array);
        boolean b1 = search.isSearchVertical(search, array);
        System.out.println(b + " " + b1);
    }
}