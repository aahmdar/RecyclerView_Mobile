package com.example.mobile_bottomnavbar.TvShow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mobile_bottomnavbar.MovieRecycler.MovieModel;
import com.example.mobile_bottomnavbar.OnItemClickListener;
import com.example.mobile_bottomnavbar.R;

import java.util.List;

public class TvRecyclerAdapter extends RecyclerView.Adapter<TvRecyclerAdapter.GridViewHolder>{
    private List<MovieModel> listMovie;
    private com.example.mobile_bottomnavbar.OnItemClickListener<MovieModel> clickListener;


    public void setMovies(List<MovieModel> movies) {
        this.listMovie = movies;
    }

    public void setClickListener(com.example.mobile_bottomnavbar.OnItemClickListener<MovieModel> clickListener) {
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_tv, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(listMovie.get(position).getPoster()).apply(new RequestOptions().override(350, 550)).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        MovieModel movie;
        ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.iv_poster_tv);
        }
        void onBind(MovieModel movie) {
            this.movie = movie;
            imgPhoto.setImageResource(movie.getPoster());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(movie);
        }
    }
}
