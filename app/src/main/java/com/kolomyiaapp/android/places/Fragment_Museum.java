package com.kolomyiaapp.android.places;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Museum extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Item> lstItem;


    public Fragment_Museum() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment3, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_3);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstItem);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerAdapter);
        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstItem = new ArrayList<>();
        int [] a = new int [] {R.drawable.museum_pysanka, R.drawable.museum_pysanka2, R.drawable.museum_pysanka1};
        int [] b = new int [] {R.drawable.muzeum_hutsul, R.drawable.muzeum_hutsul3, R.drawable.museum_hutsul1, R.drawable.museum_hutsul2};
        int [] c = new int [] {R.drawable.museum_istouii, R.drawable.museum_istouii1};
        int [] d = new int[] {R.drawable.museum_svitovyd};

        lstItem.add(new Item(getString(R.string.muz_pys), getString(R.string.muzpys), "48.528404, 25.039110", R.drawable.museum_pysanka, a));
        lstItem.add(new Item(getString(R.string.muzei_hutsul), getString(R.string.muzhucul), "48.528880, 25.037546", R.drawable.muzeum_hutsul3, b));
        lstItem.add(new Item(getString(R.string.muzei_istorii), getString(R.string.muzist), "48.528486, 25.043959", R.drawable.museum_istouii, c));
        lstItem.add(new Item(getString(R.string.svitovyd), getString(R.string.svitovyd_about),"48.527072, 25.047718", R.drawable.museum_svitovyd, d));
    }
}
