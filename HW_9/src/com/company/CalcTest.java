package com.company;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kid on 09.12.2016.
 */
public class CalcTest {

    @Test
    public void shouldSumIntegersWithoutExceptions(){
        //given
        int a =5, b = 7;
        int expected = 12;

        //when
        int actual = Calc.sum(a, b);

        //then
        assertEquals(expected, actual);
    }
}
