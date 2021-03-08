package com.example.myapplication.cours.threads.exemple2;

public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
