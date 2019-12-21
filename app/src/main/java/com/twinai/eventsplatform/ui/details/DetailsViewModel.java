package com.twinai.eventsplatform.ui.details;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.twinai.eventsplatform.MainActivity;
import com.twinai.eventsplatform.model.EventDetailModel;
import com.twinai.eventsplatform.model.EventItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public class DetailsViewModel extends ViewModel {
    public MutableLiveData<EventDetailModel> eventDetails = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();
    void fetchEventDetails(MainActivity mainActivity, int event_id){
        loading.setValue(true);
        mainActivity.networkModule.mApi.getEventDetails(event_id).enqueue(new Callback<List<EventDetailModel>>() {
            @Override
            public void onResponse(Call<List<EventDetailModel>> call, Response<List<EventDetailModel>> response) {
                loading.postValue(false);
                eventDetails.postValue(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<EventDetailModel>> call, Throwable t) {
                loading.postValue(false);
                Toast.makeText(mainActivity,"Failed request please check your internet connection",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
