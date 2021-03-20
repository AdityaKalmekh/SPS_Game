package com.example.sps_game;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Score_f extends Fragment {

    TextView score;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_score_f, container, false);
        score = view.findViewById(R.id.Score);
        String Score = this.getArguments().getString("score").toString();
        score.setText(Score);
        return view;
    }
    public void dis(int s)
    {
        score.setText(String.valueOf(s));
    }
}