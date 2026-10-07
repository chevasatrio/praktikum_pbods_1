package com.mycompany.modul4_pulsa;

/**
 * Enum provider pulsa - package-private (default access).
 * Hanya bisa diakses dalam package modul4_pulsa.
 * Ini示范: package-private untuk implementation detail yang tidak perlu diekspos ke luar.
 */
enum ProviderPulsa {
    TELKOMSEL("Telkomsel", 1.0),
    INDOSAT("Indosat Ooredoo", 0.95),
    XL("XL Axiata", 0.93),
    TRI("Tri", 0.90),
    SMARTFREN("Smartfren", 0.88);

    private final String nama;
    private final double faktorHarga; // faktor perbandingan harga

    ProviderPulsa(String nama, double faktorHarga) {
        this.nama = nama;
        this.faktorHarga = faktorHarga;
    }

    public String getNama() { return nama; }
    public double getFaktorHarga() { return faktorHarga; }
}