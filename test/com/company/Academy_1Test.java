package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Academy_1Test {
@Test
    void sumInRangeTest(){
    int result = Academy_1.sumInRange(10000000,1000000000);
    assertEquals(1,result);
}
}
