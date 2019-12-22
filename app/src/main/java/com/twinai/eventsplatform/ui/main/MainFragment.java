package com.twinai.eventsplatform.ui.main;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.twinai.eventsplatform.MainActivity;
import com.twinai.eventsplatform.R;
import com.twinai.eventsplatform.adapter.ItemAdapter;
import com.twinai.eventsplatform.databinding.MainFragmentBinding;
import com.twinai.eventsplatform.model.EventItemModel;

import java.util.Collections;
import java.util.List;

public class MainFragment extends Fragment {

    public MainViewModel mViewModel;
    private ItemAdapter mAdapter;
    private MainActivity mainActivity;
    public MainFragmentBinding binding;
    private List<EventItemModel> events;
    private String[] cities = {"Şehir","Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya", "Ardahan", "Artvin", "Aydın", "Balıkesir","Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir", "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"};
    private String[] types ={"Etkinlik Türü","Çocuk",
            "Tasavvuf",
            "Tiyatro",
            "Dram",
            "Müzik",
            "Dans",
            "Konser",
            "Sinema",
            "Oyun",
            "Konferans",
            "Seminer",
            "Eğitim",
            "Atölye",
            "Komedi",
            "Senfoni",
            "Trajedi",
            "Workshop"
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ItemAdapter(Collections.emptyList(), position -> {
            Bundle args = new Bundle();
            args.putInt("event_id",events.get(position).getId());
            mainActivity.navController.navigate(R.id.detailsFragment,args);
        });



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if(binding == null){
            binding = MainFragmentBinding.inflate(inflater,container,false);
        }
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mViewModel == null) {
            mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
            binding.setViewModel(mViewModel);
            binding.mainFeed.setAdapter(mAdapter);
            binding.mainFeed.setLayoutManager(new LinearLayoutManager(mainActivity));
            binding.mainSearch.setQueryHint("Etkinlik ara");
            binding.mainCitySpinner.setSelection(0);
            binding.mainTypeSpinner.setSelection(0);
            binding.mainSearchBtn.setOnClickListener(view -> {
                int pos_city = binding.mainCitySpinner.getSelectedItemPosition();
                String city = cities[pos_city];
                if(city.equals("Şehir"))city = "None";
                int pos_types = binding.mainTypeSpinner.getSelectedItemPosition();
                String type = types[pos_types];
                if(type.equals("Etkinlik Türü"))type = "None";
                if(type.equals("Müzik"))type="müzi";
                String query =  binding.mainSearch.getQuery().toString();
                if(query.equals(""))query="None";
                mViewModel.searchEvents(mainActivity,query,city,type);
            });
            binding.mainCitySpinner.setAdapter(new ArrayAdapter<String>(mainActivity, android.R.layout.simple_selectable_list_item
                    , cities));
            binding.mainTypeSpinner.setAdapter(new ArrayAdapter<String>(mainActivity,android.R.layout.simple_list_item_1,types));
            mViewModel.fetchFeed(mainActivity);
            observeViewModel();
        }
    }

    void observeViewModel(){
        mViewModel.eventItems.observe(this, eventItems -> {mAdapter.swapDataSet(eventItems);events = eventItems;});
        mViewModel.loading.observe(this, aBoolean -> { if(aBoolean){binding.progressBar.setVisibility(View.VISIBLE);}else{binding.progressBar.setVisibility(View.GONE);};});
    }

}
