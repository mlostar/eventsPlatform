package com.twinai.eventsplatform.ui.main;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.squareup.moshi.JsonDataException;
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
        if(mainActivity!=null) {
            mainActivity.networkModule.mApi.getEventFeed("200").enqueue(new Callback<List<EventItemModel>>() {
                @Override
                public void onResponse(Call<List<EventItemModel>> call, Response<List<EventItemModel>> response) {
                    eventItems.setValue(response.body());
                    loading.postValue(false);
                }

                @Override
                public void onFailure(Call<List<EventItemModel>> call, Throwable t) {
                    loading.postValue(false);
                    Toast.makeText(mainActivity, "Lütfen internet bağlantınızı kontrol edip tekrar deneyin", Toast.LENGTH_SHORT).show();

                }
            });
        }

        }
        void searchEvents(MainActivity mainActivity,String keyword,String city,String type){
        if(mainActivity!=null) {
            loading.postValue(true);
            mainActivity.networkModule.mApi.searchEvents(keyword, city, type).enqueue(new Callback<List<EventItemModel>>() {
                @Override
                public void onResponse(Call<List<EventItemModel>> call, Response<List<EventItemModel>> response) {
                    eventItems.setValue(response.body());
                    loading.postValue(false);
                }

                @Override
                public void onFailure(Call<List<EventItemModel>> call, Throwable t) {
                    loading.postValue(false);
                    if (t instanceof JsonDataException) {
                        Toast.makeText(mainActivity, "Filtrelere uygun sonuç bulunamadı", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mainActivity, "Lütfen internet bağlantınızı kontrol edip tekrar deneyin", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        }


    }

