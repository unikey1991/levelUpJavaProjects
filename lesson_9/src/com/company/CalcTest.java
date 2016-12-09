package com.company;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by kid on 09.12.2016.
 */
public class CalcTest {

    @Test
    public void shouldSumIntegerWithoutExceptions() {
        //given
        int a = 5;
        int b = 7;
        int expected = 12;

        //when
        int actual = Calc.sum(a, b);

        //then
        assertEquals(expected, actual);


    }
}
