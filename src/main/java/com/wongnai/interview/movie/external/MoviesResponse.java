package com.wongnai.interview.movie.external;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Stream;

public class MoviesResponse extends ArrayList<MovieData> {

    @Autowired
    private MovieDataService movieDataService;


    public List<MovieData> movieData = new ArrayList<>(Arrays.asList(
            new MovieData()
    ));


//    public List<MovieData> getMovieData(){
//        List<MovieData> movieData1 = new ArrayList<>();
//        movieDataService.fetchAll().forEach(movieData1 :: add );
//        return movieData1;
//    }

    public Stream<MovieData> getMovieData(String title){
        return movieData.stream().filter(t -> t.getTitle().equals(title));
    }



}
