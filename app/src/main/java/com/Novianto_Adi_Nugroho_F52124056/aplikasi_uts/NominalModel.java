package com.Novianto_Adi_Nugroho_F52124056.aplikasi_uts;

import java.io.Serializable;

public class NominalModel implements Serializable {
    private String title;
    private String price;

    public NominalModel(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }
}
