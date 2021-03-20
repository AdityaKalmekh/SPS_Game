package com.example.sps_game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Game_fragment extends Fragment {

    Button paperBtn,stoneBtn,scissorBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_game_fragment, container, false);
        paperBtn = view.findViewById(R.id.paper_check);
        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SPS","img_paper");
                Check check = new Check();
                check.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frameLayout,check).commit();
            }
        });
        stoneBtn = view.findViewById(R.id.stone);
        stoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SPS","img_stone");
                Check check = new Check();
                check.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frameLayout,check).commit();
            }
        });
        scissorBtn = view.findViewById(R.id.scissor);
        scissorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SPS","img_scissor");
                Check check = new Check();
                check.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frameLayout,check).commit();
            }
        });
        btnLayout();
        return view;
    }
    private void btnLayout(){

    }
}