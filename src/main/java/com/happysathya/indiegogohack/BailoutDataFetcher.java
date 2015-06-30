package com.happysathya.indiegogohack;

import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class BailoutDataFetcher {

    private static URL hackUrl;
    private static final int connectionTimeoutInMillis = 5000;

    static {
        try {
            hackUrl = new URL("https://www.indiegogo.com/projects/girl-scouts-is-foreverygirl#/story");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static BailoutData getSnapShot() {
        try {
            Document document = Jsoup.parse(hackUrl, connectionTimeoutInMillis);

            Long amount = stringToNumber(document.select("div.i-balance span.currency").get(0).text());
            Long people = stringToNumber(document.select("span.i-raised-funders").get(0).text());

            BailoutData bailoutData = new BailoutData(amount, people, new DateTime());
            System.out.println(bailoutData.toString());
            return bailoutData;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static Long stringToNumber(String value) {
        String collect = value.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        return Long.parseLong(collect);
    }
}
