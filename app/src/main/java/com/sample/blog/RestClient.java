package com.sample.blog;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.OkHttpClient.*;


public class RestClient {
    private static String Test_Url = "https://jsonplaceholder.typicode.com/";

    private Retrofit retrofit = null;

    private final RestInterface restInterface;


    public RestClient(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Builder httpClient = new Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        httpClient.addInterceptor(logging);

        Retrofit rxTutorialRetrofit = new Retrofit.Builder()
                .baseUrl(Test_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();

        restInterface = rxTutorialRetrofit.create(RestInterface.class);

    }

    public RestInterface getRestInterface(){
        return restInterface;
    }


}
