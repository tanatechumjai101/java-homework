package com.wongnai.interview.movie.search;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieRepository;
import com.wongnai.interview.movie.MovieSearchService;

import javax.persistence.Index;

@Component("invertedIndexMovieSearchService")
@DependsOn("movieDatabaseInitializer")
public class InvertedIndexMovieSearchService implements MovieSearchService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> search(String queryText) {
        //TODO: Step 4 => Please implement in-memory inverted index to search movie by keyword.
        // You must find a way to build inverted index before you do an actual search.
        // Inverted index would looks like this:
        // -------------------------------
        // |  Term      | Movie Ids      |
        // -------------------------------
        // |  Star      |  5, 8, 1       |
        // |  War       |  5, 2          |
        // |  Trek      |  1, 8          |
        // -------------------------------
        // When you search with keyword "Star", you will know immediately, by looking at Term column, and see that
        // there are 3 movie ids contains this word -- 1,5,8. Then, you can use these ids to find full movie object from repository.
        // Another case is when you find with keyword "Star War", there are 2 terms, Star and War, then you lookup
        // from inverted index for Star and for War so that you get movie ids 1,5,8 for Star and 2,5 for War. The result that
        // you have to return can be union or intersection of those 2 sets of ids.
        // By the way, in this assignment, you must use intersection so that it left for just movie id 5.

        Map<Integer, Movie> movieMap = new HashMap<>();
        Iterable<Movie> movieIterable = movieRepository.findAll();
        HashMap<String, HashSet<Integer>> stringHashSetHashMap = new HashMap<>();
        List<Movie> movieList = new ArrayList<>();
        int index = 0;

        Iterator<Movie> movieIterator = movieIterable.iterator();

        while (movieIterator.hasNext()) {
            Movie movie = movieIterator.next();
            movieMap.put(index, movie);

            String movieWord[] = movie.getName().toLowerCase().split(" ");

            for (int i = 0; i < movieWord.length; i++) {

                if (!stringHashSetHashMap.containsKey(movieWord[i])) {
                    stringHashSetHashMap.put(movieWord[i], new HashSet<>());
                }
                stringHashSetHashMap.get(movieWord[i]).add(index);
            }
            index++;
        }

        String textSearch[] = queryText.toLowerCase().split(" ");
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < textSearch.length; i++) {
            if (stringHashSetHashMap.containsKey(textSearch[i])) {
                HashSet<Integer> result_temp = new HashSet<>(stringHashSetHashMap.get(textSearch[i]));
                result.addAll(result_temp);
            }
        }
        if (result.size() > 0) {

            for (String word : textSearch) {
                result.retainAll(stringHashSetHashMap.get(word));
            }
            for (int id : result) {
                movieList.add(movieMap.get(id));
            }
        }

        return movieList;
    }
}
