package com.main.view;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.main.R;
import com.main.databinding.ActivityMainBinding;
import com.main.model.Movie;
import com.main.model.MovieResponse;
import com.main.model.TMDbAPI;
import com.main.presenter.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindingAdapter("posterImage")
    public void posterImage(ImageView view, String url){
        Glide.with(view.getContext())
                .load(url)
                .into(view);

    }

    private ActivityMainBinding binding;
    MainActivity context = this;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(context, R.layout.activity_main);

        TMDbAPI TMDbApi = ApiClient.getClient().create(TMDbAPI.class);
        Call<MovieResponse> call = TMDbApi.getMovies();

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (!response.isSuccessful()){
                    binding.results.setText("CODE: " + response.code());
                }

                List<Movie> movies = response.body().getResults();

                for (Movie movie : movies){
                    Integer movieId = movie.getId();
                    String movieTitle = movie.getTitle();
                    String movieDate = movie.getReleaseDate();
                    String movieLanguage = movie.getLanguage();
                    String moviePosterPath = movie.getPosterPath();
                    float movieAvg = movie.getVoteAverage();

                    binding.setMovie(movie);
//                    movie.posterImage(findViewById(R.id.poster), moviePosterPath);

//                    binding.poster.
                    posterImage(findViewById(R.id.poster),
                            "https://image.tmdb.org/t/p/w185" + moviePosterPath);

//                    Glide.with(context)
//                            .load("https://image.tmdb.org/t/p/w185" + moviePosterPath)
//                            .into((ImageView) findViewById(R.id.poster));

                    binding.results.append(
                            "title: " + movieTitle + "\n" +
                            "Release date: " + movieDate + "\n" +
                            "Language: " + movieLanguage + "\n" +
                            "IMDB average: "+ movieAvg + "\n\n");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                binding.results.append("ERROR: " + t.getMessage() + "\n");
            }
        });
    }
}