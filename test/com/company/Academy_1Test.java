package com.company;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Academy_1Test {

<<<<<<< HEAD

    @Test
    void testTic_TacCheckString_X_OYes() {
        String str = "XXX_OO_O_";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"X wins");
    }
    @Test
    void testTic_TacCheckString_X_O_1Yes() {
        String str = "XX_OOOXO_";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"O wins");
    }
    @Test
    void testTic_TacCheckString_X_O_2Yes() {
        String str = "XOO_O_XXX";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"X wins");
    }
    @Test
    void testTic_TacCheckString_X_O_3Yes() {
        String str = "X_XXOOXOO";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"X wins");
    }
    @Test
    void testTic_TacCheckString_X_O_4Yes() {
        String str = "OXXOO_XXO";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"O wins");
    }
    @Test
    void testTic_TacCheckString_X_O_5Yes() {
        String str = "XO_XO_XOX";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Impossible");
    }
    @Test
    void testTic_TacCheckString_X_O_6Yes() {
        String str = "XX_OXXO__";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Impossible");
    }
    @Test
    void testTic_TacCheckString_X_O_7Yes() {
        String str = "_O_X__X_X";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Impossible");
    }
    @Test
    void testTic_TacCheckString_X_O_8Yes() {
        String str = "XO_OOX_X_";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Game not finished");
    }
    @Test
    void testTic_TacCheckString_X_O_9Yes() {
        String str = "XOXOOXXXO";
        String s = Academy.tic_tacCheckString_X_O(str);
        assertEquals(s,"Draw");
    }

=======
>>>>>>> tictac5
}
