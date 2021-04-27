package com.example.mobile_bottomnavbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.example.mobile_bottomnavbar.MovieRecycler.MovieModel;

public class DetailMovieActivity extends AppCompatActivity {

    private ImageView ivPoster;
    private TextView tvTitle;
    private TextView tvGenre;
    private TextView tvSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        ivPoster = (ImageView)findViewById(R.id.iv_poster);
        tvTitle = (TextView)findViewById(R.id.tv_title);
        tvGenre = (TextView)findViewById(R.id.tv_genre);
        tvSynopsis = (TextView)findViewById(R.id.tv_synopsis) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MovieModel movieModel = getIntent().getParcelableExtra("MOVIE_DETAIL");
        System.out.println("Thisis"+ movieModel.getTitle());
            ivPoster.setImageResource(movieModel.getPoster());
            tvTitle.setText(movieModel.getTitle());
            tvGenre.setText(movieModel.getGenres());
            tvSynopsis.setText(movieModel.getSynopsis());
            getSupportActionBar().setTitle(movieModel.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}