package com.Novianto_Adi_Nugroho_F52124056.aplikasi_uts;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NominalAdapter extends RecyclerView.Adapter<NominalAdapter.NominalViewHolder> {

    private ArrayList<NominalModel> nominalList;
    private int selectedPosition = -1;

    public NominalAdapter(ArrayList<NominalModel> nominalList) {
        this.nominalList = nominalList;
    }

    @NonNull
    @Override
    public NominalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nominal, parent, false);
        return new NominalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NominalViewHolder holder, int position) {
        NominalModel item = nominalList.get(position);

        holder.tvTitle.setText(item.getTitle());
        holder.tvPrice.setText(item.getPrice());

        int currentPos = holder.getAdapterPosition();

        if (selectedPosition == currentPos) {
            holder.cardNominal.setCardBackgroundColor(Color.parseColor("#FF6F00"));
            holder.tvTitle.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvPrice.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.cardNominal.setCardBackgroundColor(Color.parseColor("#2A2A3C"));
            holder.tvTitle.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvPrice.setTextColor(Color.parseColor("#22C55E"));
        }

        holder.itemView.setOnClickListener(v -> {
            int previousPos = selectedPosition;
            selectedPosition = holder.getAdapterPosition();
            notifyItemChanged(previousPos);
            notifyItemChanged(selectedPosition);
        });
    }

    @Override
    public int getItemCount() {
        return nominalList != null ? nominalList.size() : 0;
    }

    public NominalModel getSelectedNominal() {
        if (selectedPosition >= 0 && selectedPosition < nominalList.size()) {
            return nominalList.get(selectedPosition);
        }
        return null;
    }

    public static class NominalViewHolder extends RecyclerView.ViewHolder {
        CardView cardNominal;
        TextView tvTitle, tvPrice;

        public NominalViewHolder(@NonNull View itemView) {
            super(itemView);
            cardNominal = itemView.findViewById(R.id.cardNominal);
            tvTitle = itemView.findViewById(R.id.tvNominalTitle);
            tvPrice = itemView.findViewById(R.id.tvNominalPrice);
        }
    }
}
