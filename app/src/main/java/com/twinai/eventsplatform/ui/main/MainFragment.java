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

import com.twinai.eventsplatform.MainActivity;
import com.twinai.eventsplatform.R;
import com.twinai.eventsplatform.adapter.ItemAdapter;
import com.twinai.eventsplatform.databinding.MainFragmentBinding;
import com.twinai.eventsplatform.model.EventItem;
import java.util.Collections;
import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ItemAdapter mAdapter;
    private MainActivity mainActivity;
    private MainFragmentBinding binding;
    private List<EventItem> events;
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
            args.putParcelable("event",events.get(position));
            mainActivity.navController.navigate(R.id.action_mainFragment_to_detailsFragment,args);
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
            mViewModel.fetchFeed(mainActivity);
            observeViewModel();
        }
    }
    void observeViewModel(){
        mViewModel.eventItems.observe(this, eventItems -> mAdapter.swapDataSet(eventItems));
    }

}
