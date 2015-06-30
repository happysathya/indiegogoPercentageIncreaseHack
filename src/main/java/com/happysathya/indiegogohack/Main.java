package com.happysathya.indiegogohack;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) {

        addShutdownHook();

        BailoutDataHolder T30BailoutDataHolder = new BailoutDataHolder();
        BailoutDataHolder T60BailoutDataHolder = new BailoutDataHolder();

        executorService.scheduleAtFixedRate(T30BailoutDataHolder, 0, 30, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(T60BailoutDataHolder, 0, 30, TimeUnit.MINUTES);

        System.out.println("Press Ctrl+c to quit this...");

        while (true) {
        }
    }

    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutting down all the threads...");
            executorService.shutdown();
        }));
    }

}
