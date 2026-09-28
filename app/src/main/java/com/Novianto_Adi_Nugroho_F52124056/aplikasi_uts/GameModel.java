package com.Novianto_Adi_Nugroho_F52124056.aplikasi_uts;

import java.io.Serializable;
import java.util.ArrayList;

public class GameModel implements Serializable {
    private String name;
    private String publisher;
    private String promo;
    private int imageResId;
    private String description;
    private ArrayList<NominalModel> nominalList;

    public GameModel(String name, String publisher, String promo, int imageResId, String description, ArrayList<NominalModel> nominalList) {
        this.name = name;
        this.publisher = publisher;
        this.promo = promo;
        this.imageResId = imageResId;
        this.description = description;
        this.nominalList = nominalList;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPromo() {
        return promo;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<NominalModel> getNominalList() {
        return nominalList;
    }
}
