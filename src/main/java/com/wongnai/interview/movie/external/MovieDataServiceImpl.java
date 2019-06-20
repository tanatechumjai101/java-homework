package com.wongnai.interview.movie.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class MovieDataServiceImpl implements MovieDataService {


    public static final String MOVIE_DATA_URL
            = "https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json";

    @Autowired
    private RestOperations restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public static String getMovieDataUrl() {
        return MOVIE_DATA_URL;
    }

    public RestOperations getRestTemplate() {
        return restTemplate;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public MoviesResponse fetchAll() {

        //TODO:
        // Step 1 => Implement this method to download data from MOVIE_DATA_URL and fix any error you may found.
        // Please noted that you must only read data remotely and only from given source,
        // do not download and use local file or put the file anywhere else.

        try {
            URL obj = new URL(getMovieDataUrl());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + getMovieDataUrl());
            System.out.println("Response Code : "+responseCode);
            BufferedReader in = new BufferedReader((new InputStreamReader(con.getInputStream())));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine())!= null){
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }


        return null;
    }
}
