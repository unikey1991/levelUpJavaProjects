package com.company;

public class Main {

//    static int aaa = 17;

    public static void main(String[] args) throws InterruptedException {


//        HelloWorldThread thread1 = new HelloWorldThread();
//        HelloWorldThread thread2 = new HelloWorldThread();
//        HelloWorldThread thread3 = new HelloWorldThread();
//        HelloWorldThread thread4 = new HelloWorldThread();
//        HelloWorldThread thread5 = new HelloWorldThread();
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//
//        ThreadPrinter printer1 = new ThreadPrinter(3, "wat");
//        ThreadPrinter printer2 = new ThreadPrinter(2, "wergh");
//        ThreadPrinter printer3 = new ThreadPrinter(5, "ash");
//        printer1.start();
//        printer2.start();
//        printer3.start();
//
//         startThreadAndJoin();

        syncTesting(17);


    }

    public static synchronized void print(String text) {
        System.out.println(text);
    }

    public static void startThreadAndJoin() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        ThreadPrinter printer = new ThreadPrinter(5, "sdglskg");
        printer.start();
        printer.join();
        System.out.println(Thread.currentThread().getName() + " finished");
    }

    public static void syncTesting(int stratValue) {
        final int[] aaa = {stratValue};
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    aaa[0]++;
                    //System.out.println(Thread.currentThread().getName() + " " + aaa);
                }
                System.out.println(Thread.currentThread().getName() + " " + aaa[0] + " test");

            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (thread1) {
                    if (thread1.isAlive()) {
                        try {
                            thread1.wait();
                            System.out.println(Thread.currentThread().getName() + " waiting...");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    for (int i = 0; i < 1000; i++) {
                        aaa[0]++;
                        //System.out.println(Thread.currentThread().getName() + " " + aaa);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + aaa[0] + " test");

                }
            }
        };
        thread1.start();
        thread2.start();
    }

}
