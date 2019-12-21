package com.twinai.eventsplatform.adapter;

import android.content.Context;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.twinai.eventsplatform.R;
import com.twinai.eventsplatform.databinding.MainListItemBinding;
import com.twinai.eventsplatform.model.EventItem;
import com.twinai.eventsplatform.model.EventItemModel;
import com.twinai.eventsplatform.other.ItemClickEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertlostar on 10.12.2019
 * Copyright (c) 2019 Twin to present
 * All rights reserved.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> implements Filterable {
    private List<EventItemModel> mEvents;
    private List<EventItemModel> mFilteredCancel;
    private ItemClickEvent itemClickEvent;
    private NameFilter nameFilter;
    private CityFilter cityFilter;
    public ItemAdapter(List<EventItemModel> events,ItemClickEvent clickEvent){
        mEvents = events;
        mFilteredCancel = events;
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

    @Override
    public Filter getFilter() {
            if ( nameFilter == null) {
                nameFilter = new NameFilter();
            }
            return nameFilter;
    }
    public Filter getCityFilter(){
        if(cityFilter == null){
            cityFilter = new CityFilter();

        }
        return cityFilter;
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
        mFilteredCancel = newData;
        notifyDataSetChanged();
    }
    public void filterRefresh(List<EventItemModel> newData){
        mEvents = newData;
        notifyDataSetChanged();
    }
    private class NameFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if (charSequence != null && charSequence.length() > 0) {
                List<EventItemModel> filterList = new ArrayList<>();
                for (int i = 0; i < mEvents.size(); i++) {
                    if ((mEvents.get(i).getName().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                        filterList.add(mEvents.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mFilteredCancel.size();
                results.values = mFilteredCancel;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filterRefresh((List<EventItemModel>) filterResults.values);
            notifyDataSetChanged();
        }
    }
    private class CityFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if (charSequence != null && charSequence.length() > 0) {
                List<EventItemModel> filterList = new ArrayList<>();
                for (int i = 0; i < mFilteredCancel.size(); i++) {
                    if ((mFilteredCancel.get(i).getCity().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                        filterList.add(mFilteredCancel.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mFilteredCancel.size();
                results.values = mFilteredCancel;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filterRefresh((List<EventItemModel>) filterResults.values);
            notifyDataSetChanged();
        }
    }
    }

