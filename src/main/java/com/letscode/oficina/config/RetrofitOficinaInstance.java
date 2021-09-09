package com.letscode.oficina.config;

import retrofit2.Retrofit;

public class RetrofitOficinaInstance {

    public static Retrofit getOficinaInstanceRetrofit(Boolean isLocal) {
        if (isLocal) {
            return RetrofitInitializer.getRetrofit(true);
        }
        return RetrofitInitializer.getRetrofit(false);
    }

}
