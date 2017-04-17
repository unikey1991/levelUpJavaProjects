package com.company;

/**
 * Created by unike on 17.04.2017.
 */
public class HelloWorldThread extends Thread{


    @Override
    public void run() {
            Main.print(Thread.currentThread().getName() + " Hello World");


    }

    public HelloWorldThread() {
    }
}
