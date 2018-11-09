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
public class Fragment_Monument extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Item> lstItem;

    public Fragment_Monument() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment4, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_4);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstItem);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstItem = new ArrayList<>();

        int [] a = new int [] {R.drawable.monumtnt_simpysanok, R.drawable.monumtnt_simpysanok2,R.drawable.monumtnt_simpysanok1};
        int [] b = new int [] {R.drawable.monument_franko, R.drawable.monument_franko1, R.drawable.monument_franko2};
        int [] c = new int [] {R.drawable.monument_bandera, R.drawable.monument_bandera1};
        int [] d = new int [] {R.drawable.monument_shevchenko, R.drawable.monument_shevchenko1};
        int [] e = new int [] {R.drawable.monument_grushevskyi, R.drawable.monument_grushevskyi1};
        int [] f = new int [] {R.drawable.monument_irchan, R.drawable.monument_irchan2, R.drawable.monument_irchan1};
        int [] g = new int [] {R.drawable.monument_trylovskyi, R.drawable.monument_trylovskyi1,R.drawable.monument_trylovskyi2};
        int [] h = new int [] {R.drawable.monument_shevch, R.drawable.monument_shevch1};
        int [] i = new int [] {R.drawable.monument_kryvonis, R.drawable.monument_kryvonis1, R.drawable.monument_kryvonis2};
        int [] j = new int [] {R.drawable.monument_knyga, R.drawable.monument_knyga1};
        int [] k = new int [] {R.drawable.monument_mitskevych, R.drawable.monument_mitskevych1, R.drawable.monument_mitskevych2};
        int [] l = new int [] {R.drawable.monument_chornobyl, R.drawable.monument_chornobyl1};
        int [] m = new int [] {R.drawable.monument_afgan, R.drawable.monument_afgan1};
        int [] n = new int [] {R.drawable.monument_geroiv, R.drawable.monument_geroiv1};
        int [] o = new int [] {R.drawable.monument_znak, R.drawable.monument_znak1};
        int [] p = new int [] {R.drawable.monument_fedchyk, R.drawable.monument_fedchyk1, R.drawable.monument_fedchyk2};
        int [] r = new int [] {R.drawable.monument_pavlov, R.drawable.monument_pavlov1};
        int [] s = new int [] {R.drawable.monument_kit, R.drawable.monument_kit1};
        int [] t = new int [] {R.drawable.monument_oleni, R.drawable.monument_oleni1};
        int [] u = new int [] {R.drawable.monument_maria, R.drawable.monument_maria1};
        int [] v = new int [] {R.drawable.monument_fashyzm};


        lstItem.add(new Item(getString(R.string.park_skulptur), getString(R.string.mon1), "48.528578, 25.038961", R.drawable.monumtnt_simpysanok,a));
        lstItem.add(new Item(getString(R.string.pam_frank), getString(R.string.mon2), "48.528548, 25.040424", R.drawable.monument_franko,b));
        lstItem.add(new Item(getString(R.string.pam_band), getString(R.string.mon3), "48.534266, 25.059150", R.drawable.monument_bandera1,c));
        lstItem.add(new Item(getString(R.string.pam_sh_1), getString(R.string.mon4), "48.526059, 25.038125", R.drawable.monument_shevchenko,d));
        lstItem.add(new Item(getString(R.string.pam_grush), getString(R.string.mon5), "48.530994, 25.035637", R.drawable.monument_grushevskyi1,e));
        lstItem.add(new Item(getString(R.string.pam_irch), getString(R.string.mon6), "48.527970, 25.037074", R.drawable.monument_irchan,f));
        lstItem.add(new Item(getString(R.string.pam_tryl), getString(R.string.mon7), "48.528013, 25.047146", R.drawable.monument_trylovskyi,g));
        lstItem.add(new Item(getString(R.string.pam_sh_2), getString(R.string.mon8), "48.511244, 25.034701", R.drawable.monument_shevch,h));
        lstItem.add(new Item(getString(R.string.pam_borciam), getString(R.string.mon9), "48.529866, 25.040522", R.drawable.monument_kryvonis,i));
        lstItem.add(new Item(getString(R.string.pam_druk), getString(R.string.mon10), "48.528004, 25.037781", R.drawable.monument_knyga,j));
        lstItem.add(new Item(getString(R.string.pam_mickev), getString(R.string.mon11), "48.529549, 25.049045", R.drawable.monument_mitskevych1,k));
        lstItem.add(new Item(getString(R.string.pam_chornobyl), getString(R.string.mon12), "48.525354, 25.048512", R.drawable.monument_chornobyl,l));
        lstItem.add(new Item(getString(R.string.pam_afgan), getString(R.string.mon13), "48.534070, 25.052896", R.drawable.monument_afgan,m));
        lstItem.add(new Item(getString(R.string.pam_radiansk), getString(R.string.mon14),"48.530860, 25.041810", R.drawable.monument_geroiv,n));
        lstItem.add(new Item(getString(R.string.pam_znak), getString(R.string.mon15), "48.524880, 25.038913", R.drawable.monument_znak,o));
        lstItem.add(new Item(getString(R.string.pam_zertvam), getString(R.string.mon16),"48.525903, 25.054141", R.drawable.monument_fashyzm,v));
        lstItem.add(new Item(getString(R.string.pam_fedchuk), getString(R.string.mon17), "48.532696, 25.058484", R.drawable.monument_fedchyk,p));
        lstItem.add(new Item(getString(R.string.pam_pavlovu), getString(R.string.mon18),"48.523958, 25.054866", R.drawable.monument_pavlov,r));
        lstItem.add(new Item(getString(R.string.pam_maria), getString(R.string.mon19),"48.527387, 25.046792", R.drawable.monument_maria,u));
        lstItem.add(new Item(getString(R.string.pam_kit), getString(R.string.mon20), "48.529103, 25.047771", R.drawable.monument_kit,s));
        lstItem.add(new Item(getString(R.string.pam_oleni), getString(R.string.mon21), "48.529446, 25.048456", R.drawable.monument_oleni,t));

    }
}
