package com.twinai.eventsplatform.ui.main;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.squareup.picasso.Downloader;
import com.twinai.eventsplatform.MainActivity;
import com.twinai.eventsplatform.model.EventItemModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainViewModel extends ViewModel {
    public MutableLiveData<List<EventItemModel>> eventItems = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();
    void fetchFeed(MainActivity mainActivity){

        loading.setValue(true);
        mainActivity.networkModule.mApi.getEventFeed("200").enqueue(new Callback<List<EventItemModel>>() {
            @Override
            public void onResponse(Call<List<EventItemModel>> call, Response<List<EventItemModel>> response) {
                eventItems.setValue(response.body());
                loading.postValue(false);
            }

            @Override
            public void onFailure(Call<List<EventItemModel>> call, Throwable t) {
                loading.postValue(false);
                Toast.makeText(mainActivity,"Failed request please check your internet connection",Toast.LENGTH_SHORT).show();

            }
        });


        }


    }

