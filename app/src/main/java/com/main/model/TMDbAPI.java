package com.main.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TMDbAPI {
    public final static String apiKey = "93633810e5203c9e3dda779ef240571f";

    @GET("now_playing?api_key=" + apiKey)
    Call<MovieResponse> getMovies();
}
