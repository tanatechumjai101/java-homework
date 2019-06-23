package com.wongnai.interview.movie.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieRepository;
import com.wongnai.interview.movie.MovieSearchService;

@Component("databaseMovieSearchService")
public class DatabaseMovieSearchService implements MovieSearchService {
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> search(String queryText) {
		//TODO: Step 3 => Please make all test in DatabaseMovieSearchServiceIntegrationTest run pass.
		// This database search method must use only MovieRepository.findByNameContains(String), you also have to implement
		// MovieDataSynchronizer.forceSync() to load all movie data, using MovieDataService, into MovieRepository.
		// Do not change @Component annotation on this class

		List<Movie> movieTitle = movieRepository.findByNameContains(queryText);
		String newText = "";
//		for(int i=0;i<movieTitle.size();i++){
//			String splitName[] = movieTitle.get(i).getName().split(" ");
//			for(int j=0;j<splitName.length;j++){
//				if(splitName[j].toLowerCase().equals(queryText.toLowerCase())){
//					 newText = movieTitle.get(i).getName();
//					movieRepository.findByNameContains(newText);
//				}
//
//			}
//		}
		for(int i=0;i<movieTitle.size();i++){
			newText = movieRepository.findByNameContains(queryText).get(i).getName();

		}
		return movieRepository.findByNameContains(newText);
	}
}
