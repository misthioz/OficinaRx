package com.letscode.oficina.config;

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

public class RetrofitInitializer {

    public static Retrofit getRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder().baseUrl("https://viacep.com.br/ws/").
                addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(ReactorCallAdapterFactory.create()).build();

    }

}
