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

public class FragmentReligion extends android.support.v4.app.Fragment {
    View religionView;
    private RecyclerView religionRecyclerView;
    private List<Item> religionItem;

    public FragmentReligion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        religionView = inflater.inflate(R.layout.fragment5, container, false);
        religionRecyclerView = (RecyclerView) religionView.findViewById(R.id.fragment_5);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), religionItem);
        religionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        religionRecyclerView.setAdapter(recyclerAdapter);
        return religionView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create array
        religionItem = new ArrayList<>();
        // create items
        int[] soborUP = new int[]{R.drawable.arch_soborupc, R.drawable.arch_soborupc1};
        int[] churchMykhaila = new int[]{R.drawable.arch_mikhaila, R.drawable.arch_mikhaila1, R.drawable.arch_mikhaila2};
        int[] churchYosafata = new int[]{R.drawable.arch_yosafata, R.drawable.arch_yosafata1, R.drawable.arch_yosafata2};
        int[] churchLoyoly = new int[]{R.drawable.arch_loyoly, R.drawable.arch_loyoly1, R.drawable.arch_loyoly2};
        int[] soborPreobrazennia = new int[]{R.drawable.arch_soborpreobraz, R.drawable.arch_soborpreobraz1};
        int[] churchBrahovistennia = new int[]{R.drawable.arch_blagovist, R.drawable.arch_blagovist1};
        int[] churchMykolaya = new int[]{R.drawable.arch_mykolayacharch, R.drawable.arch_mykolayacharch1};
        int[] synagoga = new int[]{R.drawable.arch_synagoga};
        int[] soborMP = new int[]{R.drawable.arch_sobourus};
        int[] churchBabtist = new int[]{R.drawable.arch_babtist};
        // add items to array
        religionItem.add(new Item(getString(R.string.sobor_kp), getString(R.string.kpsobor), "48.524181, 25.044873", R.drawable.arch_soborupc, soborUP));
        religionItem.add(new Item(getString(R.string.sobor_myh), getString(R.string.myhsobor), "48.525037, 25.035666", R.drawable.arch_mikhaila, churchMykhaila));
        religionItem.add(new Item(getString(R.string.sobor_yosaf), getString(R.string.yosafata), "48.524115, 25.040363", R.drawable.arch_yosafata, churchYosafata));
        religionItem.add(new Item(getString(R.string.kostek_loyoly), getString(R.string.loyola), "48.531592, 25.037181", R.drawable.arch_loyoly, churchLoyoly));
        religionItem.add(new Item(getString(R.string.sobor_katol), getString(R.string.katolspb), "48.530089, 25.037170", R.drawable.arch_soborpreobraz, soborPreobrazennia));
        religionItem.add(new Item(getString(R.string.cerkva_blago), getString(R.string.blagovcerkv), "48.527390, 25.023217", R.drawable.arch_blagovist, churchBrahovistennia));
        religionItem.add(new Item(getString(R.string.cerkva_mykoly), getString(R.string.cerkvmyk), "48.541804, 25.047662", R.drawable.arch_mykolayacharch, churchMykolaya));
        religionItem.add(new Item(getString(R.string.synagoga), getString(R.string.synagoga_about), "48.526487, 25.037099", R.drawable.arch_synagoga, synagoga));
        religionItem.add(new Item(getString(R.string.sobor_mp), getString(R.string.russobor), "48.529139, 25.041517", R.drawable.arch_sobourus, soborMP));
        religionItem.add(new Item(getString(R.string.cerkva_baptystiv), getString(R.string.baptysty), "48.5259405,25.0507836", R.drawable.arch_babtist, churchBabtist));
    }
}
