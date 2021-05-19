package com.company;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Academy_1Test {


    @Test
    void testTic_TacCheckString_X_OYes() {
        String str = "___OOO_O_";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"O wins");
    }
    @Test
    void testTic_TacCheckString_X_O_1Yes() {
        String str = "X__XO_XOX";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"X wins");
    }
    @Test
    void testTic_TacCheckString_X_O_2Yes() {
        String str = "XOO_X_XOX";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"X wins");
    }
    @Test
    void testTic_TacCheckString_X_O_3Yes() {
        String str = "__XOX_XOX";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"X wins");
    }
    @Test
    void testTic_TacCheckString_X_O_4Yes() {
        String str = "_X_OX_XX_";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"X wins");
    }
    @Test
    void testTic_TacCheckString_X_O_5Yes() {
        String str = "_OXOOX_OX";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Impossible");
    }
    @Test
    void testTic_TacCheckString_X_O_6Yes() {
        String str = "_OOXOXXOX";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"O wins");
    }
    @Test
    void testTic_TacCheckString_X_O_8Yes() {
        String str = "XOXOOXXXO";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Draw");
    }
    @Test
    void testTic_TacCheckString_X_O_1No() {
        String str = "XOXXOOXOX";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Impossible");
    }
    @Test
    void testTic_TacCheckString_X_O_7Yes() {
        String str = "OXXXOOXOO";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"O wins");
    }
    @Test
    void testTic_TacCheckString_X_O_3No() {
        String str = "_OOOO_X_X";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Impossible");
    }
    @Test
    void testTic_TacCheckString_X_O_4No() {
        String str = "_O_X__X_X";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Impossible");
    }
}
