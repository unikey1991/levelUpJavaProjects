package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by unike on 11.12.2016.
 */
public class Task6Test {

    @Test
    public void shouldReturnPassed(){
        //given
        String email = "abcd@ab.ab";
        String expected = "email адрес "+email+" подходит";


        //when
        String actual = Main.task6(email);


        //then
        assertEquals("Wrong actual string. Expected is email адрес "+email+" подходит", expected, actual);
    }

    @Test
    public void shouldReturnPassed1(){
        //given
        String email = "abca@abcabcabc.abca";
        String expected = "email адрес "+email+" подходит";


        //when
        String actual = Main.task6(email);


        //then
        assertEquals("Wrong actual string. Expected is email адрес "+email+" подходит", expected, actual);
    }

    @Test
    public void shouldPassNotCorrectInput(){
        //given
        String email = "abc@abcabcabc.abca";
        String expected = "email адрес до @ не может быть меньше 4 символов";


        //when
        String actual = Main.task6(email);


        //then
        assertEquals("Wrong actual string. Expected is email адрес до @ не может быть меньше 4 символов", expected, actual);
    }

    @Test
    public void shouldPassNotCorrectInput1(){
        //given
        String email = "abca@abcabcabca.abca";
        String expected = "домен не может быть меньше 2 и больше 9 символов";


        //when
        String actual = Main.task6(email);


        //then
        assertEquals("Wrong actual string. Expected is домен не может быть меньше 2 и больше 9 символов", expected, actual);
    }
}
