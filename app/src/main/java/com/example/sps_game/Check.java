package com.example.sps_game;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.Toast;
//import android.widget.Toast;

import java.util.Random;

public class Check extends Fragment {

    static int Score = 0;
    ImageView imageView,imageView2;
    View view;
    Button play_Again;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_check, container, false);
        play_Again = view.findViewById(R.id.play_Again);
        play_Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                intent.putExtra("score",Score);
                startActivity(intent);
                getActivity().finish();
            }
        });
        String player_response,computer_response;
        player_response = player_choice();
        computer_response = Computer_choice();
        Check_answer(player_response,computer_response);
        return view;
    }
    private String player_choice()
    {
        Bundle bundle = this.getArguments();
        String strText = bundle.getString("SPS");
        if(strText.equals("img_paper"))
        {
            imageView = view.findViewById(R.id.player_choice);
            imageView.setBackgroundResource(R.drawable.img_paper);
            Computer_choice();
        }
        else if (strText.equals("img_scissor"))
        {
            imageView = view.findViewById(R.id.player_choice);
            imageView.setBackgroundResource(R.drawable.img_scissor);
            Computer_choice();
        }
        else
        {
            imageView = view.findViewById(R.id.player_choice);
            imageView.setBackgroundResource(R.drawable.img_rock);
            Computer_choice();
        }
        return strText;
    }

    private String Computer_choice() {
        String[] arr = new String[]{"img_paper", "img_scissor", "img_stone"};
        Random random = new Random();
        int index = random.nextInt(arr.length);
        String computer_answer = arr[index];
        if(computer_answer.equals("img_paper"))
        {
            imageView2 = view.findViewById(R.id.Computer_choice);
            imageView2.setBackgroundResource(R.drawable.img_paper);
        }
        else if (computer_answer.equals("img_scissor"))
        {
            imageView2 = view.findViewById(R.id.Computer_choice);
            imageView2.setBackgroundResource(R.drawable.img_scissor);
        }
        else
        {
            imageView2 = view.findViewById(R.id.Computer_choice);
            imageView2.setBackgroundResource(R.drawable.img_rock);
        }
        return computer_answer;
    }
    private void Check_answer(String player_response,String computer_response)
    {
        TextView result = view.findViewById(R.id.result);
        String Draw = "DRAW";
        String Win = "YOU WIN";
        String Lose = "YOU LOSE";
        if(player_response.equals("img_paper"))
        {
            if (computer_response.equals("img_paper"))
            {
                result.setText(Draw);
            }
            else if (computer_response.equals("img_stone"))
            {
                result.setText(Win);
                Score++;
            }
            else
            {
                result.setText(Lose);
                if (Score <= 1)
                {
                    Score=0;
                }
                else
                {
                    Score--;
                }
            }
        }
        else if(player_response.equals("img_stone"))
        {
            if (computer_response.equals("img_stone"))
            {
                result.setText(Draw);
            }
            else if (computer_response.equals("img_scissor"))
            {
                result.setText(Win);
                Score++;
            }
            else
            {
                result.setText(Lose);
                if (Score <= 1)
                {
                    Score=0;
                }
                else
                {
                    Score--;
                }
            }
        }
        else
        {
            if (computer_response.equals("img_scissor"))
            {
                result.setText(Draw);
            }
            else if (computer_response.equals("img_paper"))
            {
                result.setText(Win);
                Score++;
            }
            else
            {
                result.setText(Lose);
                if (Score <= 1)
                {
                    Score=0;
                }
                else
                {
                    Score--;
                }
            }
        }
        Score_f score_f = (Score_f)getFragmentManager().findFragmentById(R.id.frameLayout2);
        score_f.dis(Score);
    }
}