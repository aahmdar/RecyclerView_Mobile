package com.example.api_movieapp;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.bumptech.glide.Glide;
import com.example.api_movieapp.models.movie.MovieDetail;
import com.example.api_movieapp.networks.Consts;
import com.example.api_movieapp.networks.GetRetrofit;
import com.example.api_movieapp.networks.MovieService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivityDetail extends AppCompatActivity {

    ImageView ivBackdrop, ivPoster;
    TextView tvTitle, tvGenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ivPoster = findViewById(R.id.iv_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvGenre = findViewById(R.id.tv_genre);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Integer tvId = getIntent().getIntExtra("TV ID", 0);
        load(tvId);
    }
    private void load(Integer id) {
        MovieService service = GetRetrofit.getInstance();

        Map<String, String> params = new HashMap<>();
        params.put("api_key", Consts.APIKEY);
        params.put("language", Consts.LANGUAGE);
        Call<MovieDetail> call = service.movieDetail(id, params);
        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                if (response.isSuccessful() && response.body() != null){
                    MovieDetail movieDetail = response.body();
                    tvTitle.setText(movieDetail.getTitle());
                    String getGenre = "";
                    for (int i = 0; i < movieDetail.getGenres().size(); i++){
                        getGenre += movieDetail.getGenres().get(i).getName() + ", ";
                    }
                    tvGenre.setText(getGenre);
                    String uri2 = Consts.IMAGEBASEURL + movieDetail.getPosterImage();
                    Glide.with(com.example.api_movieapp.MovieActivityDetail.this).load(uri2).into(ivPoster);

                    getSupportActionBar().setTitle(tvTitle.getText());
                }else {
                    Log.d(Consts.APIERROR, "error");

                }
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                Log.d(Consts.APIERROR, "error");
            }
        });

    }
}