package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by unike on 11.12.2016.
 */
public class Task5Test {

    @Test
    public void shouldReturn987654321(){
        //given
        String str = "123456789";
        String expected = "987654321";


        //when
        String actual = Main.task5(str);


        //then
        assertEquals("Wrong actual string. Expected is 987654321", expected, actual);
    }

    @Test
    public void shouldReturn321321321321321321321(){
        //given
        String str = "123123123123123123123";
        String expected = "321321321321321321321";


        //when
        String actual = Main.task5(str);


        //then
        assertEquals("Wrong actual string. Expected is 321321321321321321321", expected, actual);
    }

    @Test
    public void shouldReturnYtrewq(){
        //given
        String str = "abv - + 12 3 qwerty";
        String expected = "ytrewq 3 21 + - vba";


        //when
        String actual = Main.task5(str);


        //then
        assertEquals("Wrong actual string. Expected is ytrewq 3 21 + - vba", expected, actual);
    }


}
