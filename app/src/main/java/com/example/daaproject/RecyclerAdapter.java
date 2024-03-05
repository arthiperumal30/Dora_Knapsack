package com.example.daaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    static int calculatedTotProfit = 0;
    ArrayList<RecyclerModel> recyclerModels;

    public RecyclerAdapter(Context context, ArrayList<RecyclerModel> recyclerModels) {
        this.context = context;
        this.recyclerModels = recyclerModels;

    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.rowholder,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.objectName.setText(recyclerModels.get(position).getObjectName());
        holder.weight.setText(recyclerModels.get(position).getObjectWeight());
        holder.profit.setText(recyclerModels.get(position).getObjectProfit());
        holder.objectImg.setImageResource(recyclerModels.get(position).getImage());

        holder.selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.selectBtn.setVisibility(View.INVISIBLE);
                holder.unselectBtn.setVisibility(View.VISIBLE);
                calculatedTotProfit = calculatedTotProfit + Integer.parseInt(recyclerModels.get(position).getObjectProfit());
            }
        });

        holder.unselectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.selectBtn.setVisibility(View.VISIBLE);
                holder.unselectBtn.setVisibility(View.INVISIBLE);
                calculatedTotProfit = calculatedTotProfit - Integer.parseInt(recyclerModels.get(position).getObjectProfit());
            }
        });
    }

    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView objectName, weight, profit;
        ImageView objectImg;
        ImageButton selectBtn, unselectBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            objectName = itemView.findViewById(R.id.objectName);
            weight = itemView.findViewById(R.id.weight);
            profit = itemView.findViewById(R.id.profit);
            objectImg = itemView.findViewById(R.id.img1);
            selectBtn = itemView.findViewById(R.id.selectBtn);
            unselectBtn = itemView.findViewById(R.id.unselectBtn);




        }
    }
}
