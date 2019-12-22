package com.twinai.eventsplatform.ui.details;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;
import com.twinai.eventsplatform.MainActivity;
import com.twinai.eventsplatform.databinding.DetailsFragmentBinding;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public class DetailsFragment extends Fragment {
    private MainActivity mainActivity = null;
    private DetailsViewModel mViewModel = null;
    private DetailsFragmentBinding binding;
    private int selected_event_id;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(binding == null){
            binding = DetailsFragmentBinding.inflate(inflater,container,false);
        }
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        if (mViewModel == null) {
            mViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
            selected_event_id = getArguments().getInt("event_id");
            mViewModel.fetchEventDetails(mainActivity,selected_event_id);
            observeViewModel();
        }

    }

    private void observeViewModel() {
        mViewModel.eventDetails.observe(mainActivity, eventDetailModel -> {
            binding.setEvent(eventDetailModel);
            Picasso.get().load(eventDetailModel.getImage()).into(binding.detailsIv);
        });
        mViewModel.loading.observe(mainActivity, aBoolean -> {
            if (aBoolean) {
                binding.progressBar2.setVisibility(View.VISIBLE);
            } else {
                binding.progressBar2.setVisibility(View.GONE);
            }
        });
    }
}
