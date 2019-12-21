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
import com.twinai.eventsplatform.model.EventItem;
import com.twinai.eventsplatform.model.EventItemModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ItemAdapter mAdapter;
    private MainActivity mainActivity;
    private MainFragmentBinding binding;
    private List<EventItemModel> events;
    private String[] cities = {"","Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya", "Ardahan", "Artvin", "Aydın", "Balıkesir","Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir", "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"};
    public static MainFragment newInstance() {
        return new MainFragment();
    }

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
            binding.mainSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    mAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    mAdapter.getFilter().filter(newText);
                    return false;
                }
            });
            binding.mainSpinner.setAdapter(new ArrayAdapter<String>(mainActivity, android.R.layout.simple_list_item_1, cities));
            binding.mainSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    mAdapter.getCityFilter().filter(cities[i]);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    mAdapter.getCityFilter().filter("");

                }
            });
            mViewModel.fetchFeed(mainActivity);
            observeViewModel();
        }
    }

    void observeViewModel(){
        mViewModel.eventItems.observe(this, eventItems -> {mAdapter.swapDataSet(eventItems);events = eventItems;});
        mViewModel.loading.observe(this, aBoolean -> { if(aBoolean){binding.progressBar.setVisibility(View.VISIBLE);}else{binding.progressBar.setVisibility(View.GONE);};});
    }

}
