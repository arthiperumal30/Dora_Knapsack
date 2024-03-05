package com.example.daaproject;

import static com.example.daaproject.Activity1.wlimit;
import static com.example.daaproject.RecyclerAdapter.calculatedTotProfit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class objectSelection extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    Button finishBtn;
    TextView weightCapacity;
    static int totprofit = 0;
    static int[] answer;
    ArrayList<RecyclerModel> recyclerModels = new ArrayList<>();
    int[] objectImages = {R.drawable.umberlla, R.drawable.book, R.drawable.tape, R.drawable.boots, R.drawable.cap, R.drawable.scissor};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_selection);
        recyclerView = findViewById(R.id.recyclerView);
        finishBtn = findViewById(R.id.finishBtn);
        weightCapacity = findViewById(R.id.weightCapacity);
        weightCapacity.setText(Integer.toString(wlimit));

        setUpRecyclerModels();

        adapter = new RecyclerAdapter(this, recyclerModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        knapsack();

        finishBtn.setOnClickListener(v -> {
            Intent intent = new Intent(objectSelection.this, resultActivity.class);
            startActivity(intent);
        });
    }

    private void setUpRecyclerModels() {
        String[] objectNames = getResources().getStringArray(R.array.object_names);
        String[] objectPrices = getResources().getStringArray(R.array.object_profits);
        String[] objectWeights = getResources().getStringArray(R.array.object_weights);

        for (int i = 0; i < objectNames.length; i++) {
            recyclerModels.add(new RecyclerModel(objectNames[i],
                    objectWeights[i],
                    objectPrices[i],
                    objectImages[i]));
        }
    }

    private int findmaxproidx(int n, int[] pro) {
        int max = 0;
        int i;
        for (i = 1; i < n; i++) {
            if ((pro[max]) < (pro[i]))
                max = i;
        }
        return max;
    }

    private int findminweiidx(int n, int[] wei) {
        int min = 0;
        int i;
        for (i = 1; i < n; i++) {
            if ((wei[min]) > (wei[i])) {
                min = i;
            }
        }
        return min;
    }

    private void knapsack() {
        totprofit = 0;
        calculatedTotProfit = 0;

        int n = 6, idx, count = 0;
        int weightCap = wlimit;
        answer = new int[n];
        System.out.println("WeightCap: " + weightCap);
        int[] profit = new int[] { 50, 40, 10, 20, 30, 25};
        int[] weight = new int[] { 30, 35, 10, 25, 15, 10};

         while (count != n && weightCap != 0) {
            if (Activity1.choice.equals("maxPro"))
                idx = findmaxproidx(n, profit);
            else
                idx = findminweiidx(n, weight);

            if((weight[idx])<=weightCap)
            {
                System.out.println("idx: " + idx);
                weightCap = weightCap - (weight[idx]);
                totprofit = totprofit + (profit[idx]);
                answer[idx] = 1;
                System.out.println("totprofit: "+totprofit);

            }
             weight[idx] = 1000;
             profit[idx] = 0;
             count++;
        }
            System.out.println("Total profit: " + totprofit);
        }
    }




