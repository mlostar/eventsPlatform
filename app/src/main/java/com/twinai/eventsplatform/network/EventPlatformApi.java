package com.twinai.eventsplatform.network;

import com.twinai.eventsplatform.model.EventDetailModel;
import com.twinai.eventsplatform.model.EventItemModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public interface EventPlatformApi {

    @GET("https://ituse19-uep.herokuapp.com/api/events/{number}")
    Call<List<EventItemModel>> getEventFeed(@Path("number")String number);

    @GET("https://ituse19-uep.herokuapp.com/api/filter_search/{keyword}/{city}/{type}")
    Call<List<EventItemModel>> searchEvents(@Path("keyword")String keyword,
                                            @Path("city")String city,
                                            @Path("type")String type);

    @GET("https://ituse19-uep.herokuapp.com/api/event_detail/{event_id}")
    Call<List<EventDetailModel>> getEventDetails(@Path("event_id") int event_id);


}
