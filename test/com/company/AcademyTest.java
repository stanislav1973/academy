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
    NewPlayer newPlayer;
    Player player;
       static String[][] array = new String[10][10];

    public AcademyTest() {
        //player = new Player();
        newPlayer = new NewPlayer();
    }


    @Test
    void test(){
        array[0][9] = "O";
        array[0][8] = "~";
        Coordinate coordinate = new Coordinate("A9");
        System.out.print(new Player().checkHit(coordinate,array));
    }
}