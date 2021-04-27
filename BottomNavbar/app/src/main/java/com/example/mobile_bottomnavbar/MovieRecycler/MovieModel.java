package com.example.mobile_bottomnavbar.MovieRecycler;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {
    private int poster;
    private String title;
    private String genres;
    private String synopsis;

    public MovieModel() {

    }

    protected MovieModel(Parcel in) {
        poster = in.readInt();
        title = in.readString();
        genres = in.readString();
        synopsis = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };


    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(title);
        dest.writeString(genres);
        dest.writeString(synopsis);
    }
}
