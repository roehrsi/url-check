package com.example.urlcheck.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpRequestHandler {

    /*
     * Opens a connection to the provided http url and returns the recieved status code,
     * or 0 if no connection could be made.
     * 
     * @param urlString the url to connect to.
     * 
     * @return the http response code of the server, or 0, if no connection could be
     * established.
     */
    public static int requestHttpResponse(String urlString) {
        try {

            URI uri = new URI(urlString);
            URL url = uri.toURL();
            HttpURLConnection con;

            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            return con.getResponseCode();

        } catch (ClassCastException e) {
            System.out.println(
                    String.format("Could not establish connection. [ %s ] is not a valid http address", urlString));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // e.printStackTrace();
            System.out.println(String.format("URL [ %s ] is not a valid URL.", urlString));
        } catch (URISyntaxException e) {
            System.out.println(String.format("URL [ %s ] is not a valid URL.", urlString));
        }
        return 0;
    }

}
