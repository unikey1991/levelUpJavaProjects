package com.company;


import org.junit.Test;


import static org.junit.Assert.assertEquals;


/**
 * Created by unike on 10.12.2016.
 */
public class NumTest {

    @Test
    public void shouldReturnOne(){
        //given
        int num = 1;
        String expected = "one";


        //when
        String actual = Main.task4(num);


        //then
        assertEquals("Wrong actual number. Expected is one", expected, actual);
    }


    @Test
    public void shouldReturnFive(){
        //given
        int num = 5;
        String expected = "five";


        //when
        String actual = Main.task4(num);


        //then
        assertEquals("Wrong actual number. Expected is five", expected, actual);
    }


    @Test
    public void shouldReturnTen(){
        //given
        int num = 10;
        String expected = "ten";


        //when
        String actual = Main.task4(num);


        //then
        assertEquals("Wrong actual number. Expected is ten", expected, actual);
    }
    @Test
    public void shouldPassNotCorrectInputAndReturnZero(){
        //given
        int num = 15;
        String expected = "Число должно быть от 1 до 10";


        //when
        String actual = Main.task4(num);


        //then
        assertEquals("Wrong actual number. Expected is zero", expected, actual);
    }

}
