package com.example.mobile_bottomnavbar.Fragments;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_bottomnavbar.DetailMovieActivity;
import com.example.mobile_bottomnavbar.MovieRecycler.Databases;
import com.example.mobile_bottomnavbar.MovieRecycler.MovieModel;
import com.example.mobile_bottomnavbar.MovieRecycler.MovieRecyclerAdapter;
import com.example.mobile_bottomnavbar.OnItemClickListener;
import com.example.mobile_bottomnavbar.R;

public class MovieFragment extends Fragment implements com.example.mobile_bottomnavbar.OnItemClickListener<MovieModel> {
    private RecyclerView recyclerView;
    private MovieRecyclerAdapter adapter;
    private Databases databases;

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = v.findViewById(R.id.rv_movies);
        databases = new Databases(getActivity());
        adapter = new MovieRecyclerAdapter();
        adapter.setClickListener(this);
        adapter.setMovies(databases.getMovies());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(MovieModel movieModel) {
        Intent detailActivity = new Intent(getActivity(), com.example.mobile_bottomnavbar.DetailMovieActivity.class);
        if(movieModel!=null){
            detailActivity.putExtra("MOVIE_DETAIL", movieModel);
            startActivity(detailActivity);
        }
    }
}