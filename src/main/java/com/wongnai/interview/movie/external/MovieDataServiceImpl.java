package com.wongnai.interview.movie.external;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

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

//        try {
//            URL obj = new URL(getMovieDataUrl());
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//            int responseCode = con.getResponseCode();
//            con.setRequestMethod("GET");
//            con.setRequestProperty("title","Glorious");
//            System.out.println("\nSending 'GET' request to URL : " + getMovieDataUrl());
//            System.out.println("Response Code : " + responseCode);
//            BufferedReader in = new BufferedReader((new InputStreamReader(con.getInputStream())));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            System.out.println(response.toString());
//
//            JSONObject jsonObject = new JSONObject(getMovieDataUrl());
//            JSONArray jsonArray = jsonObject.getJSONArray("title");
//            for (int i=0;i < jsonArray.length();i++){
//                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                MovieDataServiceImpl movieDataService = new MovieDataServiceImpl();
//                movieData.setTitle( jsonObject1.getString("title"));
//
//            }
//
//            JSONArray jsonArray = jsonObject.getJSONArray("title");
//            System.out.println(jsonArray);
//            System.out.println("Size = "+jsonArray.length());
//
//            movieData.setTitle(jsonArray.toString());
//            moviesResponse.getMovieData(movieData.getTitle());
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        MoviesResponse moviesResponse = new MoviesResponse();
        ObjectMapper objectMapper = getObjectMapper();
        ResponseEntity<String> responseEntity = getRestTemplate().getForEntity(getMovieDataUrl(),String.class);

        try{
            moviesResponse = objectMapper.readValue(responseEntity.getBody(),new TypeReference<MoviesResponse>(){});

        }catch (IOException ex){
        }


        return moviesResponse;
    }
}
