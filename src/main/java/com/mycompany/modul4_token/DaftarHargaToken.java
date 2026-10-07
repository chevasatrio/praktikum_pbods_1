package com.mycompany.modul4_token;

/**
 * Daftar harga token listrik - Public API.
 * Package lain tidak perlu tahu detail kalkulasi biaya admin, PPN, dll.
 * Cukup panggil: beliToken("R1 900 VA", 10) -> dapat TokenListrik object.
 */
public class DaftarHargaToken {

    // Public method - tampilkan harga standar per golongan
    public static void tampilkanHargaStandar() {
        System.out.println("=========================================");
        System.out.println("DAFTAR HARGA TOKEN LISTRIK (per kWh)");
        System.out.println("=========================================");
        System.out.printf("%-25s %12s %12s%n", "Golongan", "Tarif/kWh", "Contoh 10kWh");
        System.out.println("-----------------------------------------");

        for (GolonganListrik g : GolonganListrik.values()) {
            TokenListrik contoh = new TokenListrik(g, 10);
            System.out.printf("%-25s Rp%,10.2f  Rp%,10.0f%n",
                    g.getLabel(), g.getHargaPerKwh(), contoh.getTotalBayar());
        }
    }

    // Public method - beli token
    public static TokenListrik beliToken(String golongan, double kwh) {
        return TokenListrik.beliToken(golongan, kwh);
    }

    // Public method - estimasi kWh dari budget
    public static double estimasiKwh(String golongan, double budget) {
        GolonganListrik g = cariGolonganPublic(golongan);
        if (g == null) return 0;

        // Binary search estimasi kWh
        double low = 1, high = 1000, mid = 0;
        for (int i = 0; i < 20; i++) {
            mid = (low + high) / 2;
            TokenListrik t = new TokenListrik(g, mid);
            if (t.getTotalBayar() <= budget) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return Math.round(low * 10) / 10.0; // pembulatan 1 desimal
    }

    // Package-private helper untuk package token
    static GolonganListrik cariGolonganPublic(String label) {
        for (GolonganListrik g : GolonganListrik.values()) {
            if (g.getLabel().equalsIgnoreCase(label)) {
                return g;
            }
        }
        return null;
    }
}