package com.sample.blog;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;


public interface RestInterface {

    @GET("users")
    Single<Response<List<SampleUserDetailsPojo>>> getUserDetails();
}
