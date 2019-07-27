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
public class FragmentPopular extends Fragment {
    View popularView;
    private RecyclerView popularRecyclerView;
    private List<Item> popularItem;

    public FragmentPopular() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        popularView = inflater.inflate(R.layout.fragment1, container, false);
        popularRecyclerView = (RecyclerView) popularView.findViewById(R.id.fragment_1);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), popularItem);
        popularRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        popularRecyclerView.setAdapter(recyclerAdapter);
        return popularView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create array
        popularItem = new ArrayList<>();
        // create items
        int[] popularFontain = new int[]{R.drawable.popular_fontan, R.drawable.popular_fontan1, R.drawable.popular_fontan2};
        int[] popularStudSkver = new int[]{R.drawable.popular_studskver, R.drawable.popular_studskver1};
        int[] popularShevchLake = new int[]{R.drawable.popular_ozeroshevch, R.drawable.popular_ozeroshevch1, R.drawable.popular_ozeroshevch2};
        int[] popularKliashtor = new int[]{R.drawable.popukar_kliashtor, R.drawable.popukar_kliashtor1, R.drawable.popukar_kliashtor2};
        int[] popularTownLake = new int[]{R.drawable.popular_miskeozero, R.drawable.popular_miskeozero1, R.drawable.popular_miskeozero2};
        int[] popularMuseumPysanka = new int[]{R.drawable.museum_pysanka, R.drawable.museum_pysanka2, R.drawable.museum_pysanka1};
        int[] popularArchRatusha = new int[]{R.drawable.arch_ratusha, R.drawable.arch_ratusha1, R.drawable.arch_ratusha2, R.drawable.arch_ratusha3, R.drawable.arch_ratusha4};
        int[] popularFontainMarket = new int[]{R.drawable.popular_fontbaz, R.drawable.popular_fontbaz1};
        // add items to array
        popularItem.add(new Item(getString(R.string.vodograi_liubovi), getString(R.string.fontlub), "48.525098, 25.038276", R.drawable.popular_fontan1, popularFontain));
        popularItem.add(new Item(getString(R.string.stud_skver), getString(R.string.skver_stud), "48.528346, 25.041064", R.drawable.popular_studskver, popularStudSkver));
        popularItem.add(new Item(getString(R.string.sh_ozero), getString(R.string.shevchoz), "48.514798, 25.030108", R.drawable.popular_ozeroshevch, popularShevchLake));
        popularItem.add(new Item(getString(R.string.kliashtor), getString(R.string.klashtor_dzerelo), "48.524426, 25.035769", R.drawable.popukar_kliashtor, popularKliashtor));
        popularItem.add(new Item(getString(R.string.miske_ozero), getString(R.string.oz_miske), "48.535709, 25.040278", R.drawable.popular_miskeozero, popularTownLake));
        popularItem.add(new Item(getString(R.string.muz_pys), getString(R.string.muzpys), "48.528404, 25.039110", R.drawable.museum_pysanka, popularMuseumPysanka));
        popularItem.add(new Item(getString(R.string.fontan), getString(R.string.font2), "48.525975, 25.038941", R.drawable.popular_fontbaz, popularFontainMarket));
        popularItem.add(new Item(getString(R.string.ratusha), getString(R.string.ratusha_about), "48.524836, 25.037023", R.drawable.arch_ratusha, popularArchRatusha));
    }
}