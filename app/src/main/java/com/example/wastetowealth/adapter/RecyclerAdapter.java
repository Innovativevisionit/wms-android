package com.example.wastetowealth.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wastetowealth.DashboardActivity;
import com.example.wastetowealth.R;
import com.example.wastetowealth.model.DashboardCards;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private static OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private final List<DashboardCards> dataList; // Replace YourModel with the actual model class

    public RecyclerAdapter(DashboardActivity dashboardActivity, List<DashboardCards> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dashboard_cards, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DashboardCards item = dataList.get(position);
        // Bind data to views in the ViewHolder
        holder.imageView.setImageResource(item.getImageUrl());
        holder.storeNameTextView.setText(item.getStoreName());
        holder.locationTextView.setText(item.getLocation());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView storeNameTextView;
        public TextView locationTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageStore);
            storeNameTextView = itemView.findViewById(R.id.storeText);
            locationTextView = itemView.findViewById(R.id.storeLocation);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                System.out.println(position);
                listener.onItemClick(position);
            }
        }
    }
}
