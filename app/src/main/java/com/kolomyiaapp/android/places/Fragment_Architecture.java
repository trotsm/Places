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
public class Fragment_Architecture extends Fragment {
    View v;
    private RecyclerView myRecyclerView;
    private List<Item> lstItem;

    public Fragment_Architecture() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment2, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_2);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstItem);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstItem = new ArrayList<>();

        int [] a = new int [] {R.drawable.arch_shkola3, R.drawable.arch_shkola31};
        int [] b = new int [] {R.drawable.arch_ratusha, R.drawable.arch_ratusha1, R.drawable.arch_ratusha2, R.drawable.arch_ratusha3, R.drawable.arch_ratusha4};
        int [] c = new int [] {R.drawable.arch_shkola1, R.drawable.arch_shkola11, R.drawable.arch_shkola12};
        int [] d = new int [] {R.drawable.arch_gimnazia, R.drawable.arch_gimnazia1, R.drawable.arch_gimnazia2};
        int [] e = new int [] {R.drawable.museum_pysanka, R.drawable.museum_pysanka2, R.drawable.museum_pysanka1};
        int [] f = new int [] {R.drawable.muzeum_hutsul, R.drawable.museum_hutsul1, R.drawable.museum_hutsul2};
        int [] g = new int [] {R.drawable.museum_istouii};
        int [] h = new int [] {R.drawable.arch_dramteatr, R.drawable.arch_dramteatr1};
        int [] n = new int [] {R.drawable.arch_nardim, R.drawable.arch_nardim1};
        int [] r = new int [] {R.drawable.arch_sokil, R.drawable.arch_sokil1, R.drawable.arch_sokil2};
        int [] s = new int [] {R.drawable.arch_vokzak, R.drawable.arch_vokzak1, R.drawable.arch_vokzak2, R.drawable.arch_vokzak3};
        int [] t = new int [] {R.drawable.arch_9shkola2, R.drawable.arch_9shkola1};
        int [] v = new int [] {R.drawable.arch_goncharna, R.drawable.arch_goncharna1};

        lstItem.add(new Item(getString(R.string.school3), getString(R.string.shkola3),"48.525547, 25.056131", R.drawable.arch_shkola3,a));
        lstItem.add(new Item(getString(R.string.ratusha), getString(R.string.ratusha_about) , "48.524836, 25.037023", R.drawable.arch_ratusha,b));
        lstItem.add(new Item(getString(R.string.school1), getString(R.string.shkola1),"48.523660, 25.040922", R.drawable.arch_shkola1,c));

        lstItem.add(new Item(getString(R.string.gimnazia), getString(R.string.gimnaz),"48.531248, 25.035817", R.drawable.arch_gimnazia,d));
        lstItem.add(new Item(getString(R.string.muz_pys), getString(R.string.muzpys), "48.528404, 25.039110", R.drawable.museum_pysanka, e));
        lstItem.add(new Item(getString(R.string.muzei_hutsul), getString(R.string.muzhucul), "48.528880, 25.037546", R.drawable.muzeum_hutsul3, f));
        lstItem.add(new Item(getString(R.string.muzei_istorii), getString(R.string.muzist), "48.528486, 25.043959", R.drawable.museum_istouii, g));
        lstItem.add(new Item(getString(R.string.teatr), getString(R.string.teater),"48.528103, 25.037298", R.drawable.arch_dramteatr,h));
        lstItem.add(new Item(getString(R.string.nardim), getString(R.string.narodnijdim),"48.529304, 25.037433", R.drawable.arch_nardim,n));
        lstItem.add(new Item(getString(R.string.sokil), getString(R.string.sokil_pro),"48.531562, 25.041156", R.drawable.arch_sokil,r));
        lstItem.add(new Item(getString(R.string.vokzal), getString(R.string.vokzal_about),"48.534435, 25.060083", R.drawable.arch_vokzak,s));
        lstItem.add(new Item(getString(R.string.school9), getString(R.string.shkola9),"48.529424, 25.039002", R.drawable.arch_9shkola2,t));
        lstItem.add(new Item(getString(R.string.goncharna), getString(R.string.gonch),"48.522223, 25.036313", R.drawable.arch_goncharna,v));
        // lstItem.add(new Item("", "","", R.drawable.arch_sobourus,v));

    }

    }


