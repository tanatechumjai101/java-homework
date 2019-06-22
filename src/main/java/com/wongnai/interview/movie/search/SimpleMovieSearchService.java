package com.wongnai.interview.movie.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wongnai.interview.movie.external.MovieData;
import com.wongnai.interview.movie.external.MoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieSearchService;
import com.wongnai.interview.movie.external.MovieDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component("simpleMovieSearchService")
public class SimpleMovieSearchService implements MovieSearchService {

    @Autowired
    private MovieDataService movieDataService;

    @Override
    public List<Movie> search(String queryText) {
        //TODO: Step 2 => Implement this method by using data from MovieDataService
        // All test in SimpleMovieSearchServiceIntegrationTest must pass.
        // Please do not change @Component annotation on this class

        MoviesResponse moviesResponse = movieDataService.fetchAll();
        List<Movie> list = new ArrayList<>();
        for (int i = 0; i < moviesResponse.size(); i++) {

            String splitTitle[] = moviesResponse.get(i).getTitle().split(" ");
            for (int j = 0; j < splitTitle.length; j++) {
                if (splitTitle[j].toLowerCase().equals(queryText.toLowerCase())) {
                    list.add(new Movie(moviesResponse.get(i).getTitle(),moviesResponse.get(i).getCast()));
                }
            }
        }


        return list;
    }
}
