package com.company;

import java.util.concurrent.*;

public class Main {

    private static volatile int number = 17;


    public static void main(String[] args) throws InterruptedException {


//        new HelloWorldThread().start();
//        new HelloWorldThread().start();
//        new HelloWorldThread().start();
//        new HelloWorldThread().start();
//        new HelloWorldThread().start();
//
//        ThreadPrinter printer1 = new ThreadPrinter(3, "wat");
//        ThreadPrinter printer2 = new ThreadPrinter(2, "wergh");
//        ThreadPrinter printer3 = new ThreadPrinter(5, "ash");
//        printer1.start();
//        printer2.start();
//        printer3.start();
//
//         startThreadAndJoin();


        /*new Test().start();
        new Test().start();*/


//////////////lesson
/*Atomiv int test*/

        /*Semaphore semaphore = new Semaphore(3);
        long sleepTime = 500;


        Client c1 = new Client(1);
        Client c2 = new Client(2);
        Client c3 = new Client(3);
        Client c4 = new Client(4);



        ExecutorService executorService = Executors.newCachedThreadPool();*/

        /*executorService.execute(() -> c1.increaseBalance(50));
        executorService.execute(() -> c2.increaseBalance(25));
        executorService.execute(() -> c3.reduceBalance(25)); //75
        executorService.execute(() -> c1.increaseBalance(25));
        executorService.execute(() -> c1.reduceBalance(100)); //75
        executorService.execute(() -> c2.increaseBalance(50));
        executorService.execute(() -> c2.increaseBalance(100));
        executorService.execute(() -> c2.reduceBalance(75)); //200
        executorService.execute(() -> c4.increaseBalance(75));
        executorService.execute(() -> c4.increaseBalance(75));
        executorService.execute(() -> c4.reduceBalance(200)); //50*/

        /* 4erez Semaphore */
        /*executorService.execute(() -> {
            try {
                semaphore.acquire();

                c1.increaseBalance(50);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c2.increaseBalance(25);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c3.reduceBalance(25);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }); //75
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c1.increaseBalance(25);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c1.reduceBalance(100);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }); //75
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c2.increaseBalance(50);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c2.increaseBalance(100);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c2.reduceBalance(75);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }); //200
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c4.increaseBalance(75);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c4.increaseBalance(75);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                semaphore.acquire();

                c4.reduceBalance(200);
                Thread.sleep(sleepTime);
                semaphore.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }); //50

        Thread.sleep(2000);


        System.out.println("Client 1: "+ c1.getBalance());
        System.out.println("Client 2: "+ c2.getBalance());
        System.out.println("Client 3: "+ c3.getBalance());
        System.out.println("Client 4: "+ c4.getBalance());

        executorService.shutdown();*/

        CountDownLatch latch = new CountDownLatch(5);
        CyclicBarrier barrier = new CyclicBarrier(5);

        new CountDownThread(latch, "Bob").start();
        Thread.sleep(500);
        new CountDownThread(latch, "Gil").start();
        Thread.sleep(500);
        new CountDownThread(latch, "Tom").start();
        Thread.sleep(500);
        new CountDownThread(latch, "Barbara").start();
        Thread.sleep(500);
        new CountDownThread(latch, "Anton").start();

    }

    public static void sendEmail(String sender) {
        System.out.println("Email sent from: " + sender);
    }

    static class CountDownThread extends Thread {
        private final CountDownLatch latch;
        private final String sender;

        CountDownThread(CountDownLatch latch, String sender) {
            this.latch = latch;
            this.sender = sender;

            latch.countDown();
        }

        @Override
        public void run() {
            System.out.println("Waiting for last sender");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Begin email processing for " + sender);
            sendEmail(sender);
        }
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

    public static synchronized void syncTesting() {
        for (int i = 0; i < 1000; i++) {
            Main.number += 1;
        }
        System.out.println(Main.number + " " + Thread.currentThread().getName());

    }

}
