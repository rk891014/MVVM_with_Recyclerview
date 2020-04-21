package com.rohit.mvvm_with_recyclerview;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rohit.mvvm_with_recyclerview.Models.User;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    ArrayList<User> userArrayList;

    public Adapter(Activity context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        User user = userArrayList.get(position);
        RecyclerViewViewHolder viewHolder= (RecyclerViewViewHolder) holder;

        viewHolder.title.setText(user.getTitle());
        viewHolder.id.setText(user.getId());
        Glide.with(context).load(user.geturl_s()).into(((RecyclerViewViewHolder) holder).image_profile);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        ImageView image_profile;
        TextView id,title;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            image_profile=itemView.findViewById(R.id.image);
            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);


        }
    }
}