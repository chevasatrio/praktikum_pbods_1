package com.mycompany.modul4_token;

/**
 * Enum golongan listrik - package-private.
 * Implementation detail: hanya package token yang perlu tahu golongan apa saja.
 */
enum GolonganListrik {
    R1_450_VA("R1 450 VA", 415.0),
    R1_900_VA("R1 900 VA", 1352.0),
    R1_1300_VA("R1 1300 VA", 1444.7),
    R1_2200_VA("R1 2200 VA", 1444.7),
    R2_3500_5500_VA("R2 3500-5500 VA", 1699.53),
    B2_6600_200KVA("B2 6600 VA - 200 kVA", 1444.7),
    B3_200KVA("B3 > 200 kVA", 1114.74),
    I3_200KVA("I3 > 200 kVA", 1114.74),
    P1_6600_200KVA("P1 6600 VA - 200 kVA", 1699.53);

    private final String label;
    private final double hargaPerKwh; // tarif dasar PLN per kWh

    GolonganListrik(String label, double hargaPerKwh) {
        this.label = label;
        this.hargaPerKwh = hargaPerKwh;
    }

    public String getLabel() { return label; }
    public double getHargaPerKwh() { return hargaPerKwh; }
}