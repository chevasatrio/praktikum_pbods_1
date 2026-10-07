package com.mycompany.modul4_token;

/**
 * Token Listrik - produk token PLN.
 * Package-private constructor, factory method public.
 * Admin fee dan biaya admin di-handle internal.
 */
public class TokenListrik {
    private final GolonganListrik golongan;
    private final double kwh; // jumlah kWh yang dibeli
    private final double hargaDasar; // kwh * tarif
    private final double biayaAdmin; // biaya admin tetap
    private final double totalBayar; // hargaDasar + biayaAdmin + PPN 1%

    // Package-private constructor
    TokenListrik(GolonganListrik golongan, double kwh) {
        this.golongan = golongan;
        this.kwh = kwh;
        this.hargaDasar = kwh * golongan.getHargaPerKwh();
        this.biayaAdmin = hitungBiayaAdmin(kwh);
        this.totalBayar = Math.round((hargaDasar + biayaAdmin) * 1.01); // +1% PPN
    }

    // Package-private helper
    static double hitungBiayaAdmin(double kwh) {
        if (kwh <= 10) return 2500;
        if (kwh <= 20) return 3500;
        if (kwh <= 50) return 5000;
        return 7500;
    }

    // Public factory method - API untuk package lain
    public static TokenListrik beliToken(String golonganLabel, double kwh) {
        GolonganListrik gol = cariGolongan(golonganLabel);
        if (gol == null) {
            throw new IllegalArgumentException("Golongan tidak valid: " + golonganLabel);
        }
        if (kwh < 1 || kwh > 1000) {
            throw new IllegalArgumentException("KWh harus 1 - 1000");
        }
        return new TokenListrik(gol, kwh);
    }

    // Package-private helper
    static GolonganListrik cariGolongan(String label) {
        for (GolonganListrik g : GolonganListrik.values()) {
            if (g.getLabel().equalsIgnoreCase(label)) {
                return g;
            }
        }
        return null;
    }

    // Public getters
    public GolonganListrik getGolongan() { return golongan; }
    public double getKwh() { return kwh; }
    public double getHargaDasar() { return hargaDasar; }
    public double getBiayaAdmin() { return biayaAdmin; }
    public double getTotalBayar() { return totalBayar; }

    @Override
    public String toString() {
        return String.format("Token %s - %.1f kWh: Dasar Rp%,.0f + Admin Rp%,.0f = Total Rp%,.0f",
                golongan.getLabel(), kwh, hargaDasar, biayaAdmin, totalBayar);
    }
}