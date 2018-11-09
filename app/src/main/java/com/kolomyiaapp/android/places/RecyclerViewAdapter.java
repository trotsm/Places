package com.kolomyiaapp.android.places;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    public static final String EXTRA_NAME = "com.example.android.kolomyia.NAME";
    public static final String EXTRA_DESCRIPTION = "com.example.android.kolomyia.DISTANCE";
    public static final String EXTRA_COORDINATES = "com.example.android.kolomyia.COORDITATES";
    public static final String EXTRA_IMAGE = "com.example.android.kolomyia.IMAGE";
    public static final String EXTRA_SLIDER = "com.example.android.kolomyia.SLIDER";


    Context mContext;
    List<Item> mData;

    public RecyclerViewAdapter(Context mContext, List<Item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_description.setText(mData.get(position).getDescription());
        holder.tv_coordinates.setText(mData.get(position).getCoordinates());
        Glide.with(mContext).load(mData.get(position).getPhoto()).asBitmap().into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailActivity.class);//open DetailActivity
                String name = holder.tv_name.getText().toString(); // get name of item
                String description = holder.tv_description.getText().toString(); // get description of item
                String coordinates = holder.tv_coordinates.getText().toString(); // get coordinates of item

                Bundle bundle = new Bundle();
                bundle.putInt(EXTRA_IMAGE, mData.get(holder.getAdapterPosition()).getPhoto());
                bundle.putIntArray(EXTRA_SLIDER, mData.get(holder.getAdapterPosition()).getIMGslider());
                intent.putExtras(bundle);

                intent.putExtra(EXTRA_NAME, name); // send name to DetailActivity
                intent.putExtra(EXTRA_DESCRIPTION, description); // send description to DetailActivity
                intent.putExtra(EXTRA_COORDINATES, coordinates); // send coordinates to DetailActivity
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name;
        private TextView tv_description;
        private TextView tv_coordinates;
        private ImageView img;


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.name_fragment_blank);
            tv_description = (TextView) itemView.findViewById(R.id.description_fragment_blank);
            tv_coordinates = (TextView) itemView.findViewById(R.id.coordinates_fragment_blank);
            img = (ImageView) itemView.findViewById(R.id.img_fragment_blank);
        }
    }
    }
