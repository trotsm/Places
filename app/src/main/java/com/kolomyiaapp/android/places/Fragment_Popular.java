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
public class Fragment_Popular extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Item> lstItem;


    public Fragment_Popular() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment1, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_1);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstItem);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstItem = new ArrayList<>();
        int [] a = new int [] {R.drawable.popular_fontan, R.drawable.popular_fontan1, R.drawable.popular_fontan2};
        int [] b = new int [] {R.drawable.popular_studskver, R.drawable.popular_studskver1};
        int [] c = new int [] {R.drawable.popular_ozeroshevch, R.drawable.popular_ozeroshevch1, R.drawable.popular_ozeroshevch2};
        int [] d = new int [] {R.drawable.popukar_kliashtor, R.drawable.popukar_kliashtor1,R.drawable.popukar_kliashtor2};
        int [] e = new int [] {R.drawable.popular_miskeozero, R.drawable.popular_miskeozero1, R.drawable.popular_miskeozero2};
        int [] f = new int [] {R.drawable.museum_pysanka, R.drawable.museum_pysanka2, R.drawable.museum_pysanka1};
        int [] x = new int [] {R.drawable.arch_ratusha, R.drawable.arch_ratusha1, R.drawable.arch_ratusha2, R.drawable.arch_ratusha3, R.drawable.arch_ratusha4};
        int [] v = new int [] {R.drawable.popular_fontbaz, R.drawable.popular_fontbaz1};

        lstItem.add(new Item(getString(R.string.vodograi_liubovi), getString(R.string.fontlub),"48.525098, 25.038276", R.drawable.popular_fontan1, a));
        lstItem.add(new Item(getString(R.string.stud_skver), getString(R.string.skver_stud),"48.528346, 25.041064", R.drawable.popular_studskver, b));
        lstItem.add(new Item(getString(R.string.sh_ozero), getString(R.string.shevchoz),"48.514798, 25.030108", R.drawable.popular_ozeroshevch,c));
        lstItem.add(new Item(getString(R.string.kliashtor), getString(R.string.klashtor_dzerelo), "48.524426, 25.035769", R.drawable.popukar_kliashtor,d));
        lstItem.add(new Item(getString(R.string.miske_ozero), getString(R.string.oz_miske), "48.535709, 25.040278",R.drawable.popular_miskeozero,e));
        lstItem.add(new Item(getString(R.string.muz_pys), getString(R.string.muzpys), "48.528404, 25.039110", R.drawable.museum_pysanka, f));
        lstItem.add(new Item(getString(R.string.fontan), getString(R.string.font2),"48.525975, 25.038941", R.drawable.popular_fontbaz,v));
        lstItem.add(new Item(getString(R.string.ratusha), getString(R.string.ratusha_about), "48.524836, 25.037023", R.drawable.arch_ratusha,x));


    }
}