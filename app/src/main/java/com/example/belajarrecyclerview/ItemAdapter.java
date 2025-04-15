package com.example.belajarrecyclerview;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> itemList;

    private final OnItemCLickListener listener;
    public interface OnItemCLickListener {
        void onItemClick(Item makananModel);
    }

    // constructor
    public ItemAdapter(List<Item> itemList, OnItemCLickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    // Memasang data satu persatu
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item makananModel = itemList.get(position);
        holder.titleTextView.setText(makananModel.getTitle());
        holder.descriptionTextView.setText(makananModel.getDescription());
        holder.priceTextView.setText(makananModel.getPrice());
        holder.itemImageView.setImageResource(makananModel.getItemiImageView());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(makananModel));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // ViewHolder Class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, descriptionTextView, priceTextView;
        ImageView itemImageView;

        @SuppressLint("WrongViewCast")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            itemImageView = itemView.findViewById(R.id.itemImageView);
        }
    }
}
