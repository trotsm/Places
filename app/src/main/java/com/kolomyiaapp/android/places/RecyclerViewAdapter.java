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
    List<Item> tabsLists;

    public RecyclerViewAdapter(Context mContext, List<Item> tabsLists) {
        this.mContext = mContext;
        this.tabsLists = tabsLists;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        MyViewHolder vHolder = new MyViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.listName.setText(tabsLists.get(position).getName());
        holder.listDescription.setText(tabsLists.get(position).getDescription());
        holder.ListCoordinates.setText(tabsLists.get(position).getCoordinates());
        Glide.with(mContext).load(tabsLists.get(position).getPhoto()).asBitmap().into(holder.listImage);
        // send data from tab list to DetailActivity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailActivity.class);//open DetailActivity
                String name = holder.listName.getText().toString(); // get name of item
                String description = holder.listDescription.getText().toString(); // get description of item
                String coordinates = holder.ListCoordinates.getText().toString(); // get coordinates of item

                Bundle bundle = new Bundle();
                bundle.putInt(EXTRA_IMAGE, tabsLists.get(holder.getAdapterPosition()).getPhoto());
                bundle.putIntArray(EXTRA_SLIDER, tabsLists.get(holder.getAdapterPosition()).getIMGSlider());
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
        return tabsLists.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView listName;
        private TextView listDescription;
        private TextView ListCoordinates;
        private ImageView listImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            listName = (TextView) itemView.findViewById(R.id.name_fragment_blank);
            listDescription = (TextView) itemView.findViewById(R.id.description_fragment_blank);
            ListCoordinates = (TextView) itemView.findViewById(R.id.coordinates_fragment_blank);
            listImage = (ImageView) itemView.findViewById(R.id.img_fragment_blank);
        }
    }
}
