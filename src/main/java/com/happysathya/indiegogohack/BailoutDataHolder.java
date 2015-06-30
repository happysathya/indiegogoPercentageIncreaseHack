package com.happysathya.indiegogohack;

public class BailoutDataHolder implements Runnable {

    private BailoutData lastSnapShot = null;
    private final Object syncObject = new Object();

    @Override
    public void run() {
        synchronized (syncObject) {
            try {
                BailoutData currentSnapShot = BailoutDataFetcher.getSnapShot();
                if (lastSnapShot != null) {

                    double amountIncreaseInPercentage = ((double) (currentSnapShot.getAmount() - lastSnapShot.getAmount())) / lastSnapShot.getAmount() * 100;
                    double peopleIncreaseInPercentage = ((double) (currentSnapShot.getNumberOfPeople() - lastSnapShot.getNumberOfPeople())) / lastSnapShot.getNumberOfPeople() * 100;

                    System.out.println("***************************");
                    System.out.println("amountIncreaseInPercentage: " + amountIncreaseInPercentage);
                    System.out.println("peopleIncreaseInPercentage: " + peopleIncreaseInPercentage);
                    System.out.println("timeCollected: " + currentSnapShot.getTimeCollected());
                    System.out.println("***************************");
                    System.out.println();
                }
                lastSnapShot = currentSnapShot;
            } catch (RuntimeException ex) {
                System.out.println("Exception happened: " + ex.getMessage());
                System.out.println();
            }
        }
    }
}
