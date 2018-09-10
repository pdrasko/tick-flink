package com.amazonaws.sample;

import java.lang.Thread;

public class TickProcessor extends Thread {

    @Override
    public void interrupt() {
        System.out.println("Executing TickProcessor.interrupt()");
        super.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.printf("Found TickProcessor.InterruptedException (%s)\n", e);
            }
        }
    }
}
