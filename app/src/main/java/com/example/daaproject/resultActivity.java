package com.example.daaproject;

import static com.example.daaproject.RecyclerAdapter.calculatedTotProfit;
import static com.example.daaproject.objectSelection.answer;
import static com.example.daaproject.objectSelection.totprofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class resultActivity extends AppCompatActivity {
    TextView resultMsg;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    ArrayList<RecyclerModel> recyclerModels = new ArrayList<>();
    int[] objectImages = {R.drawable.umberlla, R.drawable.book, R.drawable.tape, R.drawable.boots, R.drawable.cap, R.drawable.scissor};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultMsg = findViewById(R.id.textView2);
        recyclerView = findViewById(R.id.answerRecyclerView);
        setUpAnswerRecyclerModels();

        if(objectSelection.totprofit == calculatedTotProfit)
        {
            resultMsg.setText("Congratulations! Your answer is correct :)");
        }
        else
        {
            resultMsg.setText("Oh no! Your answer is incorrect");
        }

        System.out.println("Calculated Profit: "+calculatedTotProfit);
        System.out.println("Actual Profit: "+totprofit);
        adapter = new RecyclerAdapter(this, recyclerModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void  setUpAnswerRecyclerModels()
    {
        String[] objectNames = getResources().getStringArray(R.array.object_names);
        String[] objectPrices = getResources().getStringArray(R.array.object_profits);
        String[] objectWeights = getResources().getStringArray(R.array.object_weights);

        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == 1)
            {
                recyclerModels.add(new RecyclerModel(objectNames[i],
                        objectWeights[i],
                        objectPrices[i],
                        objectImages[i]));
            }
        }
    }
}