package ua.dp.levelup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by java on 20.06.2017.
 */


public class TestScope {

    private String text;

    public TestScope() {
    }


    public void setText(String text) {
        this.text = text;
    }

    public void print(){
        System.out.println(text);
    }
}
