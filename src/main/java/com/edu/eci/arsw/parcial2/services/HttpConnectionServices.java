package com.edu.eci.arsw.parcial2.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionServices {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";
//    private static final String URL = "https://www.alphavantage.co/query?";
//    private static final String urlFunction = "function=TIME_SERIES_DAILY&";
//    private static final String urlFunction = "function=";
//    private static final String urlSymbol = "&symbol=";
//    private static final String urlInterval = "&interval=5min";
//    private static final String urlKey = "&apikey=Q1QZFVJQ21K7C6XM";

    public StringBuffer getAcciones() throws IOException {

//        System.out.println(URL+urlFunction+function+urlSymbol+symbol+urlInterval+urlKey);
//        URL obj = new URL(URL+urlFunction+function+urlSymbol+symbol+urlInterval+urlKey);
        URL obj = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response);
            System.out.println(response.toString());
            return response;
        } else {
            System.out.println("GET request not worked");
            return null;
        }
//        System.out.println("GET DONE");
    }
}
