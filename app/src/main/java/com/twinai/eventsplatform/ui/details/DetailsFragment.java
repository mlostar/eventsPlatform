package com.twinai.eventsplatform.ui.details;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.squareup.picasso.Picasso;
import com.twinai.eventsplatform.MainActivity;
import com.twinai.eventsplatform.R;
import com.twinai.eventsplatform.databinding.DetailsFragmentBinding;
import com.twinai.eventsplatform.databinding.MainFragmentBinding;
import com.twinai.eventsplatform.model.EventItem;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public class DetailsFragment extends Fragment {
    private MainActivity mainActivity = null;
    private DetailsViewModel mViewModel = null;
    private DetailsFragmentBinding binding;
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
            EventItem event = getArguments().getParcelable("event");
            mViewModel.selectedEvent = event;
            binding.setEvent(event);
            Picasso.get().load(event.getImage()).into(binding.detailsIv);
            observeViewModel();
        }

    }

    private void observeViewModel() {
    }
}
