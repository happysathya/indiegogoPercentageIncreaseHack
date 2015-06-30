package com.happysathya.indiegogohack;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BailoutDataFetcherTest {

    @Test
    public void testGetSnapShot() {
        BailoutData currentSnapShot = BailoutDataFetcher.getSnapShot();
        assertNotNull(currentSnapShot.getAmount());
        assertNotNull(currentSnapShot.getNumberOfPeople());
    }
}