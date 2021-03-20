package com.example.sps_game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    Fragment fragment;
    Button rules;
    TextView score;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.darkblue));
        }
        Game_fragment game_fragment = new Game_fragment();
        Score_f score_f = new Score_f();
        Intent intent = getIntent();
        int s = intent.getIntExtra("score",0);   // Receive score from check
        Bundle bundle = new Bundle();
        bundle.putString("score",String.valueOf(s));
        score_f.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, game_fragment);
        fragmentTransaction.add(R.id.frameLayout2, score_f);
        fragmentTransaction.commit();
        rules = findViewById(R.id.rules);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Rules.class);
                intent1.putExtra("score",s);
                startActivity(intent1);
            }
        });
    }
}