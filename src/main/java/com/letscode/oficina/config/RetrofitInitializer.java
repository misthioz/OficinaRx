package com.letscode.oficina.config;

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import com.letscode.oficina.config.constant.ConstantsCore;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

public class RetrofitInitializer {

    public static Retrofit getRetrofit(Boolean isLocal) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder().baseUrl(isLocal ?
                        ConstantsCore.BASE_URL_LOCAL_SYNC :
                        ConstantsCore.BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(ReactorCallAdapterFactory.create()).build();
    }

}
