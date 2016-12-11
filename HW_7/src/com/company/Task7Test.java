package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by unike on 11.12.2016.
 */
public class Task7Test {



    @Test
    public void shouldReturnPassed(){
        //given
        int minLength = 3;
        String arr[] = new String[]{"1","12","123","1234","12345","1234","123","1234","123","12345"};
        String expected = "123, 1234, 12345.";


        //when
        String actual = Main.task7(arr, minLength);


        //then
        assertEquals("Wrong actual string. Expected is 123, 12345.", expected, actual);
    }

    @Test
    public void shouldReturnPassed1(){
        //given
        int minLength = 6;
        String arr[] = new String[]{"1","12","123","1234","12345","1234","123","1234","123","12345"};
        String expected = ".";


        //when
        String actual = Main.task7(arr, minLength);


        //then
        assertEquals("Wrong actual string. Expected is .", expected, actual);
    }

    @Test
    public void shouldReturnNotCorrectInput(){
        //given
        int minLength = -1;
        String arr[] = new String[]{"1","12","123","1234","12345","1234","123","1234","123","12345"};
        String expected = "min length may be > 0";


        //when
        String actual = Main.task7(arr, minLength);


        //then
        assertEquals("Wrong actual string. Expected is min length may be > 0", expected, actual);
    }




}
