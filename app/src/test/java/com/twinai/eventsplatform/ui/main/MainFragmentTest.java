package com.twinai.eventsplatform.ui.main;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.twinai.eventsplatform.MainActivity;

import junit.framework.TestCase;

import org.apache.tools.ant.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

import static org.junit.Assert.*;

/**
 * Created by mertlostar on 22.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
@RunWith(RobolectricTestRunner.class)
public class MainFragmentTest extends TestCase {
    private Context context = ApplicationProvider.getApplicationContext();
    ActivityController<MainActivity>controller;

    @Test
    public void onAttach() {
        assertNotNull(context);
    }

    @Test
    public void onCreate() {
        controller  = Robolectric.buildActivity(MainActivity.class).create().start().visible();
        assertNotNull(controller);

    }

    @Test
    public void onCreateView() {
        controller  = Robolectric.buildActivity(MainActivity.class).create().start().visible();
        MainFragment fragment = (MainFragment) controller.get().navHostFragment.getChildFragmentManager().getFragments().get(0);
        assertNotNull(fragment);
        assertNotNull(fragment.binding);
    }

    @Test
    public void onActivityCreated() {
        controller  = Robolectric.buildActivity(MainActivity.class).create().start().visible();
        assertNotNull(controller.get().navController);
    }

    @Test
    public void observeViewModel() {
        controller  = Robolectric.buildActivity(MainActivity.class).create().start().visible();
        MainFragment fragment = (MainFragment) controller.get().navHostFragment.getChildFragmentManager().getFragments().get(0);
        assertNotNull(fragment);
        fragment.mViewModel.fetchFeed(controller.get());
        fragment.mViewModel.fetchFeed(null);
        fragment.mViewModel.searchEvents(controller.get(),"test","test","test");
        fragment.mViewModel.searchEvents(controller.get(),"istanbul","None","None");
    }
}