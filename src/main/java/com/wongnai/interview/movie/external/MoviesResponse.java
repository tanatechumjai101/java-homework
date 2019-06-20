package com.wongnai.interview.movie.external;

import java.util.*;
import java.net.*;
import java.io.*;

public class MoviesResponse extends ArrayList<MovieData> {

    MovieDataServiceImpl mds = new MovieDataServiceImpl();

    MoviesResponse mr = new MoviesResponse();

    public MovieDataServiceImpl getMds() {
        return mds;
    }

    public void setMds(MovieDataServiceImpl mds) {
        this.mds = mds;
    }




}
