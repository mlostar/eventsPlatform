package com.twinai.eventsplatform.network;

import com.twinai.eventsplatform.model.EventDetailModel;
import com.twinai.eventsplatform.model.EventItem;
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

    @GET("https://ituse19-uep.herokuapp.com/api/filterby_type/{type}")
    Call<List<EventItemModel>> getFilterByType(@Path("type") String type);

    @GET("https://ituse19-uep.herokuapp.com/api/filterby_city/{city}")
    Call<List<EventItemModel>> getFilterByCity(@Path("city") String city);

    @GET("https://ituse19-uep.herokuapp.com/api/search/{keyword}")
    Call<List<EventItemModel>> getFilterByKeyword(@Path("keyword") String keyword);

    @GET("https://ituse19-uep.herokuapp.com/api/event_detail/{event_id}")
    Call<List<EventDetailModel>> getEventDetails(@Path("event_id") int event_id);


}
