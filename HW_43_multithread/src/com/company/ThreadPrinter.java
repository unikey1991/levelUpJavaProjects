package com.company;

/**
 * Created by unike on 17.04.2017.
 */
public class ThreadPrinter extends Thread{


    private int count;
    private String text;

    public ThreadPrinter(int count, String text) {
        this.count = count;
        this.text = text;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(Thread.currentThread().getName() +
                    " " + text );
        }
    }
}
