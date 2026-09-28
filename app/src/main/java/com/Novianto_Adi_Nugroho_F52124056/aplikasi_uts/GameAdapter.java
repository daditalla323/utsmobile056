package com.Novianto_Adi_Nugroho_F52124056.aplikasi_uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private Context context;
    private ArrayList<GameModel> gameList;

    public GameAdapter(Context context, ArrayList<GameModel> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_game, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        GameModel game = gameList.get(position);

        holder.tvName.setText(game.getName());
        holder.tvPublisher.setText(game.getPublisher());
        holder.tvPromo.setText(game.getPromo());
        holder.imgGame.setImageResource(game.getImageResId());

        View.OnClickListener openDetail = v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("EXTRA_GAME", game);
            context.startActivity(intent);
        };

        holder.btnTopUp.setOnClickListener(openDetail);
        holder.itemView.setOnClickListener(openDetail);
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGame;
        TextView tvName, tvPublisher, tvPromo;
        Button btnTopUp;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGame = itemView.findViewById(R.id.imgGame);
            tvName = itemView.findViewById(R.id.tvGameName);
            tvPublisher = itemView.findViewById(R.id.tvPublisher);
            tvPromo = itemView.findViewById(R.id.tvPromo);
            btnTopUp = itemView.findViewById(R.id.btnTopUp);
        }
    }
}
