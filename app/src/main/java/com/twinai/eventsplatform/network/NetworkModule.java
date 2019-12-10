package com.twinai.eventsplatform.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public class NetworkModule {
    private Retrofit mRetrofit;
    public EventPlatformApi mApi;
    public NetworkModule(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://google.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        mApi = mRetrofit.create(EventPlatformApi.class);

    }


}
