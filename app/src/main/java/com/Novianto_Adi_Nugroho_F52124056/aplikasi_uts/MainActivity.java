package com.Novianto_Adi_Nugroho_F52124056.aplikasi_uts;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvGameList;
    private ArrayList<GameModel> gameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGameList = findViewById(R.id.rvGameList);
        rvGameList.setLayoutManager(new LinearLayoutManager(this));

        // Inisialisasi Data Game
        gameList = new ArrayList<>();

        // Mobile Legends
        ArrayList<NominalModel> mlNominals = new ArrayList<>();
        mlNominals.add(new NominalModel("86 Diamonds", "Rp 22.000"));
        mlNominals.add(new NominalModel("172 Diamonds", "Rp 44.000"));
        mlNominals.add(new NominalModel("Weekly Pass", "Rp 28.000"));
        mlNominals.add(new NominalModel("257 Diamonds", "Rp 65.000"));
        mlNominals.add(new NominalModel("706 Diamonds", "Rp 175.000"));
        mlNominals.add(new NominalModel("2195 Diamonds", "Rp 500.000"));

        gameList.add(new GameModel(
                "Mobile Legends",
                "Moonton",
                "Promo Weekly Diamond Pass",
                R.drawable.ic_mlbb,
                "Top up Diamond Mobile Legends Bang Bang instan, murah, dan terpercaya. Cukup masukkan User ID & Zone ID Anda untuk proses otomatis kilat.",
                mlNominals
        ));

        // PUBG Mobile
        ArrayList<NominalModel> pubgNominals = new ArrayList<>();
        pubgNominals.add(new NominalModel("60 UC", "Rp 14.000"));
        pubgNominals.add(new NominalModel("325 UC", "Rp 70.000"));
        pubgNominals.add(new NominalModel("660 UC", "Rp 140.000"));
        pubgNominals.add(new NominalModel("1800 UC", "Rp 350.000"));
        pubgNominals.add(new NominalModel("3850 UC", "Rp 700.000"));

        gameList.add(new GameModel(
                "PUBG Mobile",
                "Tencent Games",
                "Diskon UC hingga 20%",
                R.drawable.ic_pubg,
                "Top up UC PUBG Mobile termurah. Masukkan Player ID Anda untuk pengisian kilat langsung masuk ke dalam akun.",
                pubgNominals
        ));

        // Free Fire
        ArrayList<NominalModel> ffNominals = new ArrayList<>();
        ffNominals.add(new NominalModel("70 Diamonds", "Rp 10.000"));
        ffNominals.add(new NominalModel("140 Diamonds", "Rp 20.000"));
        ffNominals.add(new NominalModel("355 Diamonds", "Rp 50.000"));
        ffNominals.add(new NominalModel("720 Diamonds", "Rp 100.000"));
        ffNominals.add(new NominalModel("Pass Mingguan", "Rp 30.000"));
        ffNominals.add(new NominalModel("Pass Bulanan", "Rp 150.000"));

        gameList.add(new GameModel(
                "Free Fire",
                "Garena",
                "Bonus Diamond Membership",
                R.drawable.ic_ff,
                "Top up Diamond Free Fire resmi Garena. Cukup masukkan Player ID Free Fire Anda untuk klaim bonusnya.",
                ffNominals
        ));

        // Genshin Impact
        ArrayList<NominalModel> genshinNominals = new ArrayList<>();
        genshinNominals.add(new NominalModel("Welkin Moon", "Rp 79.000"));
        genshinNominals.add(new NominalModel("300+30 Crystals", "Rp 79.000"));
        genshinNominals.add(new NominalModel("980+110 Crystals", "Rp 249.000"));
        genshinNominals.add(new NominalModel("1980+260 Crystals", "Rp 479.000"));
        genshinNominals.add(new NominalModel("3280+600 Crystals", "Rp 799.000"));

        gameList.add(new GameModel(
                "Genshin Impact",
                "COGNOSPHERE",
                "Genesis Crystal + Bonus",
                R.drawable.ic_genshin,
                "Top up Genesis Crystal & Blessing of the Welkin Moon Genshin Impact. Masukkan User ID dan Server Anda.",
                genshinNominals
        ));

        // Valorant
        ArrayList<NominalModel> valorantNominals = new ArrayList<>();
        valorantNominals.add(new NominalModel("475 VP", "Rp 50.000"));
        valorantNominals.add(new NominalModel("1000 VP", "Rp 100.000"));
        valorantNominals.add(new NominalModel("2050 VP", "Rp 200.000"));
        valorantNominals.add(new NominalModel("3650 VP", "Rp 350.000"));
        valorantNominals.add(new NominalModel("5350 VP", "Rp 500.000"));

        gameList.add(new GameModel(
                "Valorant",
                "Riot Games",
                "VP Point Instan Transfer",
                R.drawable.ic_valorant,
                "Top up Valorant Points (VP) cepat dan aman. Masukkan Riot ID beserta Tagline Anda (misal: Player#1234).",
                valorantNominals
        ));

        // Honkai: Star Rail
        ArrayList<NominalModel> honkaiNominals = new ArrayList<>();
        honkaiNominals.add(new NominalModel("Express Pass", "Rp 79.000"));
        honkaiNominals.add(new NominalModel("300+30 Shards", "Rp 79.000"));
        honkaiNominals.add(new NominalModel("980+110 Shards", "Rp 249.000"));
        honkaiNominals.add(new NominalModel("1980+260 Shards", "Rp 479.000"));
        honkaiNominals.add(new NominalModel("3280+600 Shards", "Rp 799.000"));

        gameList.add(new GameModel(
                "Honkai: Star Rail",
                "COGNOSPHERE",
                "Express Supply Pass Ready",
                R.drawable.ic_honkai,
                "Top up Oneiric Shard & Express Supply Pass Honkai: Star Rail. Masukkan User ID dan Server Anda.",
                honkaiNominals
        ));

        // Set Adapter
        GameAdapter adapter = new GameAdapter(this, gameList);
        rvGameList.setAdapter(adapter);
    }
}
