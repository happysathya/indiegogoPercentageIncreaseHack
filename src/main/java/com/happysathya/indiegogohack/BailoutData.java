package com.happysathya.indiegogohack;

import org.joda.time.DateTime;

public class BailoutData {

    private Long amount;
    private Long numberOfPeople;
    private DateTime timeCollected;

    public BailoutData(Long amount, Long numberOfPeople, DateTime timeCollected) {
        this.amount = amount;
        this.numberOfPeople = numberOfPeople;
        this.timeCollected = timeCollected;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getNumberOfPeople() {
        return numberOfPeople;
    }

    public DateTime getTimeCollected() {
        return timeCollected;
    }

    @Override
    public String toString() {
        return "BailoutData{" +
                "amount=" + amount +
                ", numberOfPeople=" + numberOfPeople +
                ", timeCollected=" + timeCollected +
                '}';
    }
}
