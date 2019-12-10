package com.twinai.eventsplatform.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.twinai.eventsplatform.MainActivity;
import com.twinai.eventsplatform.model.EventItem;
import com.twinai.eventsplatform.other.JsonUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<EventItem>> eventItems = new MutableLiveData<>();
    void fetchFeed(MainActivity mainActivity){
        //TODO This is dummy data
        String fileName = "items.json";
        String loadJSONFromAsset = JsonUtils.loadJSONFromAsset(mainActivity, fileName);
        Moshi moshi = new Moshi.Builder().build();
        Type listMyData = Types.newParameterizedType(List.class, EventItem.class);
        JsonAdapter<List<EventItem>> adapter = moshi.adapter(listMyData);
        List<EventItem> response = null;
        try {
            response  =  adapter.fromJson(loadJSONFromAsset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response!=null){
        this.eventItems.setValue(response);
        }
        }
    }

