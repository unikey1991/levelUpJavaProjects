package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by unike on 11.12.2016.
 */
public class Task3Test {

    @Test
    public void shouldReturnChetverg(){
        //given
        int num1 = 1;
        String dayName = "четверг";
        String expected = "четверг";


        //when
        String actual = Main.task3(num1, dayName);


        //then
        assertEquals("Wrong actual string. Expected is четверг", expected, actual);
    }

    @Test
    public void shouldReturnChetverg1(){
        //given
        int num1 = 365;
        String dayName = "четверг";
        String expected = "четверг";


        //when
        String actual = Main.task3(num1, dayName);


        //then
        assertEquals("Wrong actual string. Expected is четверг", expected, actual);
    }

    @Test
    public void shouldPassNotCorrectInput(){
        //given
        int num1 = 1;
        String dayName = "";
        String expected = "wrong start day name";


        //when
        String actual = Main.task3(num1, dayName);


        //then
        assertEquals("Wrong actual string. Expected is wrong start day name", expected, actual);
    }

    @Test
    public void shouldPassNotCorrectInput1(){
        //given
        int num1 = 0;
        String dayName = "понедельник";
        String expected = "wrong number";


        //when
        String actual = Main.task3(num1, dayName);


        //then
        assertEquals("Wrong actual string. Expected is wrong number", expected, actual);
    }
}
