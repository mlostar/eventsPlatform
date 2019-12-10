package com.twinai.eventsplatform.network;

import com.twinai.eventsplatform.model.EventItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public interface EventPlatformApi {

    @GET("?")
    Call<List<EventItem>> getSearchResults();

    @GET("?")
    Call<List<EventItem>> getEventFeed();
}
