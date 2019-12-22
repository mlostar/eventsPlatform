package com.twinai.eventsplatform.adapter;

import android.content.Context;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.twinai.eventsplatform.databinding.MainListItemBinding;
import com.twinai.eventsplatform.model.EventItemModel;
import com.twinai.eventsplatform.other.ItemClickEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    private List<EventItemModel> mEvents;
    private ItemClickEvent itemClickEvent;
    public ItemAdapter(List<EventItemModel> events,ItemClickEvent clickEvent){
        mEvents = events;
        itemClickEvent = clickEvent;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainListItemBinding binding = MainListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(binding.getRoot(),binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindItem(mEvents.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }



    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private MainListItemBinding binding;
        public ItemViewHolder(@NonNull View itemView,MainListItemBinding bind) {
            super(itemView);
            mContext = itemView.getContext();
            binding = bind;
        }
        public void bindItem(EventItemModel eventItem,int position){

            binding.setPosition(position);
            binding.setEvent(eventItem);
            binding.setClickEvent(itemClickEvent);
            binding.itemText.setText(eventItem.getText());
            Picasso.get().load(eventItem.getImage()).into(binding.itemImage);
            binding.invalidateAll();
        }
        }

        public void swapDataSet(List<EventItemModel> newData) {
        mEvents = newData;
        notifyDataSetChanged();
    }


    }

