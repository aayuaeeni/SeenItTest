package com.bms.com.seenittest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bms.com.seenittest.R;
import com.bms.com.seenittest.model.ItemsModel;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Raju Sah
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder>
{

    private Context mContext;
    private List<ItemsModel> itemsModelList;

    public ItemListAdapter(Context mContext, List<ItemsModel> itemsModelList)
    {
        this.mContext = mContext;
        this.itemsModelList = itemsModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position)
    {
        ItemsModel itemsModel = itemsModelList.get(position);
        holder.title.setText(itemsModel.getName());
        // loading album cover using Glide library
        Glide.with(mContext).load(itemsModel.getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount()
    {
        return itemsModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view)
        {
            super(view);
            title = view.findViewById(R.id.title);
            thumbnail = view.findViewById(R.id.thumbnail);
        }
    }
}
