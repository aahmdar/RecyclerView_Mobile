package com.example.mobile_bottomnavbar.MovieRecycler;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.mobile_bottomnavbar.R;

import java.util.ArrayList;
import java.util.List;

public class Databases {
    private Context context;

    public Databases(Context context) {
        this.context = context;
    }

    public List<MovieModel> getMovies() {
        List<MovieModel> movies = new ArrayList<>();
        TypedArray posters = context.getResources().obtainTypedArray(R.array.posters);
        String[] titles = context.getResources().getStringArray(R.array.titles);
        String[] genres = context.getResources().getStringArray(R.array.genres);
        String[] synopsis = context.getResources().getStringArray(R.array.synopsis);
        for (int i = 0; i < titles.length; i++) {
            MovieModel movie = new MovieModel();
            movie.setPoster(posters.getResourceId(i, -1));
            movie.setTitle(titles[i]);
            movie.setGenres(genres[i]);
            movie.setSynopsis(synopsis[i]);
            movies.add(movie);
        }
        return movies;
    }
}

