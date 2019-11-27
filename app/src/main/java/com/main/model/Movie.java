package com.main.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.SerializedName;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;


public class Movie {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String description;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("title")
    private String title;
    @SerializedName("original_language")
    private String language;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("vote_count")
    private Integer voteCount;
    @SerializedName("video")
    private Boolean video;

//    private boolean isFavorite;

    // constructer
    public Movie(Integer id, String title, String posterPath, String language,
                 String description, String releaseDate, float voteAverage,
                 String originalTitle, List<Integer> gemreIds, String backdropPath,
                 Double popularity, Integer voteCount, Boolean video){

        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.language = language;
        this.description = description;
        this.language = language;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;

    }

    // getter
    public Integer getId(){
        return this.id;
    }
    public String getPosterPath(){
       return this.posterPath;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public String getLanguage(){
        return this.language;
    }
    public String getReleaseDate(){
        return this.releaseDate;
    }
    public float getVoteAverage(){
        return this.voteAverage;
    }
    public List<Integer> getGenreIds() {
        return this.genreIds;
    }

}