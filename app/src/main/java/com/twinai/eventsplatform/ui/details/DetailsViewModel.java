package com.twinai.eventsplatform.ui.details;

import androidx.lifecycle.ViewModel;

import com.twinai.eventsplatform.model.EventItem;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public class DetailsViewModel extends ViewModel {
    public EventItem selectedEvent;
    void assignEvent(EventItem event){
        this.selectedEvent = event;
    }
}
