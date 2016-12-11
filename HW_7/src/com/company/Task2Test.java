package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by unike on 11.12.2016.
 */
public class Task2Test {


    @Test
    public void shouldReturnSheterkaPik(){
        //given
        int num1 = 1;
        int num2 = 6;
        String expected = "шестерка пик";


        //when
        String actual = Main.task2(num1, num2);


        //then
        assertEquals("Wrong actual string. Expected is шестерка пик", expected, actual);
    }

    @Test
    public void shouldReturnTuzChervei(){
        //given
        int num1 = 4;
        int num2 = 14;
        String expected = "туз червей";


        //when
        String actual = Main.task2(num1, num2);


        //then
        assertEquals("Wrong actual string. Expected is туз червей", expected, actual);
    }

    @Test
    public void shouldPassNotCorrectInput(){
        //given
        int num1 = 5;
        int num2 = 13;
        String expected = "неверный номер!";


        //when
        String actual = Main.task2(num1, num2);


        //then
        assertEquals("Wrong actual string. Expected is неверный номер!", expected, actual);
    }
}
