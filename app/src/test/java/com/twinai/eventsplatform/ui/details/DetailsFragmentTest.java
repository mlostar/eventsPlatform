package com.twinai.eventsplatform.ui.details;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.twinai.eventsplatform.MainActivity;
import com.twinai.eventsplatform.R;
import com.twinai.eventsplatform.ui.main.MainFragment;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

import static org.junit.Assert.*;

/**
 * Created by mertlostar on 22.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */

@RunWith(RobolectricTestRunner.class)
public class DetailsFragmentTest extends TestCase {
    private Context context = ApplicationProvider.getApplicationContext();
    ActivityController<MainActivity> controller;

    @Test
    public void onAttach() {
        assertNotNull(context);
    }

    @Test
    public void onCreateView() {
        controller  = Robolectric.buildActivity(MainActivity.class).create().start().visible();
        assertNotNull(controller.get().navController);
        controller.get().navController.navigate(R.id.detailsFragment);
        DetailsFragment fragment = (DetailsFragment) controller.get().navHostFragment.getChildFragmentManager().getFragments().get(0);
        assertNotNull(fragment.binding);
    }

    @Test
    public void onActivityCreated() {
        controller  = Robolectric.buildActivity(MainActivity.class).create().start().visible();
        assertNotNull(controller.get().navController);
        controller.get().navController.navigate(R.id.detailsFragment);
        DetailsFragment fragment = (DetailsFragment) controller.get().navHostFragment.getChildFragmentManager().getFragments().get(0);
        assertNotNull(fragment);
    }
}