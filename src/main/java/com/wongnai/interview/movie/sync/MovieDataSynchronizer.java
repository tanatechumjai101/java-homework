package com.wongnai.interview.movie.sync;

import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;

import com.wongnai.interview.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.MovieRepository;
import com.wongnai.interview.movie.external.MovieDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class MovieDataSynchronizer {
	@Autowired
	private MovieDataService movieDataService;

	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public void forceSync() {
		//TODO: implement this to sync movie into repository
//		movieDataService.fetchAll();

		movieRepository.findByNameContains(movieDataService.fetchAll().toString());

	}
}
