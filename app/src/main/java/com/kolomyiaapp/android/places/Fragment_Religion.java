package com.kolomyiaapp.android.places;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class Fragment_Religion extends android.support.v4.app.Fragment {
    View v;
    private RecyclerView myRecyclerView;
    private List<Item> lstItem;

    public Fragment_Religion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment5, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_5);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstItem);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstItem = new ArrayList<>();


        int [] i = new int [] {R.drawable.arch_soborupc, R.drawable.arch_soborupc1};
        int [] j = new int [] {R.drawable.arch_mikhaila, R.drawable.arch_mikhaila1,R.drawable.arch_mikhaila2};
        int [] k = new int [] {R.drawable.arch_yosafata, R.drawable.arch_yosafata1, R.drawable.arch_yosafata2};
        int [] l = new int [] {R.drawable.arch_loyoly,R.drawable.arch_loyoly1, R.drawable.arch_loyoly2};
        int [] m = new int [] {R.drawable.arch_soborpreobraz, R.drawable.arch_soborpreobraz1};
        int [] o = new int [] {R.drawable.arch_blagovist, R.drawable.arch_blagovist1};
        int [] p = new int [] {R.drawable.arch_mykolayacharch, R.drawable.arch_mykolayacharch1};
        int [] u = new int [] {R.drawable.arch_synagoga};
        int [] w = new int [] {R.drawable.arch_sobourus};
        int [] x = new int [] {R.drawable.arch_babtist};

        lstItem.add(new Item(getString(R.string.sobor_kp), getString(R.string.kpsobor),"48.524181, 25.044873", R.drawable.arch_soborupc,i));
        lstItem.add(new Item(getString(R.string.sobor_myh), getString(R.string.myhsobor),"48.525037, 25.035666", R.drawable.arch_mikhaila,j));
        lstItem.add(new Item(getString(R.string.sobor_yosaf), getString(R.string.yosafata),"48.524115, 25.040363", R.drawable.arch_yosafata,k));
        lstItem.add(new Item(getString(R.string.kostek_loyoly), getString(R.string.loyola),"48.531592, 25.037181", R.drawable.arch_loyoly,l));
        lstItem.add(new Item(getString(R.string.sobor_katol), getString(R.string.katolspb),"48.530089, 25.037170", R.drawable.arch_soborpreobraz,m));
        lstItem.add(new Item(getString(R.string.cerkva_blago), getString(R.string.blagovcerkv),"48.527390, 25.023217", R.drawable.arch_blagovist,o));
        lstItem.add(new Item(getString(R.string.cerkva_mykoly), getString(R.string.cerkvmyk),"48.541804, 25.047662", R.drawable.arch_mykolayacharch,p));
        lstItem.add(new Item(getString(R.string.synagoga), getString(R.string.synagoga_about),"48.526487, 25.037099", R.drawable.arch_synagoga,u));
        lstItem.add(new Item(getString(R.string.sobor_mp), getString(R.string.russobor),"48.529139, 25.041517", R.drawable.arch_sobourus,w));
        lstItem.add(new Item(getString(R.string.cerkva_baptystiv), getString(R.string.baptysty),"48.5259405,25.0507836", R.drawable.arch_babtist,x));
        // lstItem.add(new Item("", "","", R.drawable.arch_sobourus,v));

    }
}
