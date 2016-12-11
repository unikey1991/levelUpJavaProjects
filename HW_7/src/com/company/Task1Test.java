package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by unike on 10.12.2016.
 */
public class Task1Test {

    @Test
    public void shouldReturn31(){
        //given
        int num = 1;
        int expected = 31;


        //when
        int actual = Main.task1(Main.args1, num);


        //then
        assertEquals("Wrong actual number. Expected is 31", expected, actual);
    }

    @Test
    public void shouldReturn31_2(){
        //given
        int num = 12;
        int expected = 31;


        //when
        int actual = Main.task1(Main.args1, num);


        //then
        assertEquals("Wrong actual number. Expected is 31", expected, actual);
    }

    @Test
    public void shouldPassNotCorrectInputAndReturnZero(){
        //given
        int num = 13;
        int expected = 0;


        //when
        int actual = Main.task1(Main.args1, num);


        //then
        assertEquals("Wrong actual number. Expected is zero", expected, actual);
    }
}
