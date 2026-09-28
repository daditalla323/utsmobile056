package com.Novianto_Adi_Nugroho_F52124056.aplikasi_uts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailActivity extends AppCompatActivity {

    private View btnBackContainer;
    private ImageView btnBack, imgDetailGame;
    private TextView tvDetailGameName, tvDetailPublisher, tvDetailPromo;
    private TextView tvDetailDescription;
    private RecyclerView rvNominals;
    private EditText etUserId, etZoneId;
    private Button btnProcessTopUp;

    private NominalAdapter nominalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();

        GameModel game = (GameModel) getIntent().getSerializableExtra("EXTRA_GAME");

        if (game != null) {
            imgDetailGame.setImageResource(game.getImageResId());
            tvDetailGameName.setText(game.getName());
            tvDetailPublisher.setText(game.getPublisher());
            tvDetailPromo.setText(game.getPromo());
            tvDetailDescription.setText(game.getDescription());

            if (game.getNominalList() != null) {
                rvNominals.setLayoutManager(new GridLayoutManager(this, 2));
                nominalAdapter = new NominalAdapter(game.getNominalList());
                rvNominals.setAdapter(nominalAdapter);
            }
        }

        View.OnClickListener goBack = v -> getOnBackPressedDispatcher().onBackPressed();
        btnBack.setOnClickListener(goBack);
        btnBackContainer.setOnClickListener(goBack);

        btnProcessTopUp.setOnClickListener(v -> {
            NominalModel selectedNominal = (nominalAdapter != null) ? nominalAdapter.getSelectedNominal() : null;
            String userId = etUserId.getText().toString().trim();

            if (selectedNominal == null) {
                Toast.makeText(this, "Silakan pilih paket nominal yang ingin di-top up!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (userId.isEmpty()) {
                etUserId.setError("User ID wajib diisi!");
                Toast.makeText(this, "Silakan masukkan User ID akun Anda!", Toast.LENGTH_SHORT).show();
                return;
            }

            String gameName = (game != null) ? game.getName() : "Game";
            String infoMessage = "Top Up " + gameName + " (" + selectedNominal.getTitle() + " - " + selectedNominal.getPrice() + ") untuk ID: " + userId + " Berhasil diproses!";

            Toast.makeText(this, infoMessage, Toast.LENGTH_LONG).show();
        });
    }

    private void initViews() {
        btnBackContainer = findViewById(R.id.btnBackContainer);
        btnBack = findViewById(R.id.btnBack);
        imgDetailGame = findViewById(R.id.imgDetailGame);
        tvDetailGameName = findViewById(R.id.tvDetailGameName);
        tvDetailPublisher = findViewById(R.id.tvDetailPublisher);
        tvDetailPromo = findViewById(R.id.tvDetailPromo);
        tvDetailDescription = findViewById(R.id.tvDetailDescription);
        rvNominals = findViewById(R.id.rvNominals);
        etUserId = findViewById(R.id.etUserId);
        etZoneId = findViewById(R.id.etZoneId);
        btnProcessTopUp = findViewById(R.id.btnProcessTopUp);
    }
}
