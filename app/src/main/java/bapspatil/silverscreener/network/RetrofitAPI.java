package bapspatil.silverscreener.network;
import bapspatil.silverscreener.model.TMDBCreditsResponse;
import bapspatil.silverscreener.model.TMDBDetailsResponse;
import bapspatil.silverscreener.model.TMDBResponse;
import bapspatil.silverscreener.model.TMDBReviewResponse;
import bapspatil.silverscreener.model.TMDBTrailerResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Raj chowdhury
 */

public interface RetrofitAPI {

    
    String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342";
    String BACKDROP_BASE_URL = "https://image.tmdb.org/t/p/w500";
    String BASE_URL = "https://api.themoviedb.org/3/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("movie/{type}")
    Call<TMDBResponse> getMovies(@Path("type") String TYPE, @Query("api_key") String API_KEY, @Query("language") String LANGUAGE, @Query("page") int PAGE);

    @GET("search/movie")
    Call<TMDBResponse> searchMovies(@Query("api_key") String API_KEY, @Query("language") String LANGUAGE, @Query("page") int PAGE, @Query("query") String QUERY);

    @GET("movie/{movie_id}/videos")
    Call<TMDBTrailerResponse> getTrailers(@Path("movie_id") int MOVIE_ID, @Query("api_key") String API_KEY, @Query("language") String LANGUAGE);

    @GET("movie/{movie_id}/reviews")
    Call<TMDBReviewResponse> getReviews(@Path("movie_id") int MOVIE_ID, @Query("api_key") String API_KEY, @Query("language") String LANGUAGE);

    @GET("movie/{movie_id}/credits")
    Call<TMDBCreditsResponse> getCredits(@Path("movie_id") int MOVIE_ID, @Query("api_key") String API_KEY);

    @GET("movie/{movie_id}")
    Call<TMDBDetailsResponse> getDetails(@Path("movie_id") int MOVIE_ID, @Query("api_key") String API_KEY, @Query("language") String LANGUAGE);

    @GET("movie/{movie_id}/similar")
    Call<TMDBResponse> getSimilarMovies(@Path("movie_id") int MOVIE_ID, @Query("api_key") String API_KEY, @Query("language") String LANGUAGE);

}
