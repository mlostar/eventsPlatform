package com.twinai.eventsplatform.ui.details;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.twinai.eventsplatform.MainActivity;
import com.twinai.eventsplatform.R;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public class DetailsFragment extends Fragment {
    private MainActivity mainActivity = null;
    private DetailsViewModel mViewModel = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            mViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
            // TODO: Use the ViewModel
    }
}
