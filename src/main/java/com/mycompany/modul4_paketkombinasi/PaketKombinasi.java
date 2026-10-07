package com.mycompany.modul4_paketkombinasi;

import com.mycompany.modul4_pulsa.DaftarHargaPulsa;
import com.mycompany.modul4_pulsa.Pulsa;
import com.mycompany.modul4_token.DaftarHargaToken;
import com.mycompany.modul4_token.TokenListrik;

/**
 * Paket Kombinasi Pulsa + Token - Demonstrasi package working together.
 * Package ini MENGGUNAKAN public API dari package pulsa & token.
 * Tidak bisa akses class package-private (ProviderPulsa, GolonganListrik, Pulsa constructor, TokenListrik constructor).
 * Hanya bisa pakai: DaftarHargaPulsa.beliPulsa(), DaftarHargaToken.beliToken()
 * 
 * Ini示范: 
 * - Package sebagai boundary enkapsulasi
 * - Public API = kontrak yang stabil
 * - Implementation detail (enum, constructor, helper) tersembunyi
 */
public class PaketKombinasi {
    private final Pulsa pulsa;
    private final TokenListrik token;
    private final double diskonPaket; // diskun 5% kalau beli keduanya

    public PaketKombinasi(String providerPulsa, int nominalPulsa, String golonganToken, double kwhToken) {
        // Menggunakan PUBLIC API dari package lain - INI YANG BENAR
        this.pulsa = DaftarHargaPulsa.beliPulsa(providerPulsa, nominalPulsa);
        this.token = DaftarHargaToken.beliToken(golonganToken, kwhToken);
        this.diskonPaket = (pulsa.getHargaJual() + token.getTotalBayar()) * 0.05;
    }

    public Pulsa getPulsa() { return pulsa; }
    public TokenListrik getToken() { return token; }
    public double getDiskonPaket() { return diskonPaket; }
    public double getTotalBayar() { return pulsa.getHargaJual() + token.getTotalBayar() - diskonPaket; }

    public void printStruk() {
        System.out.println("=========================================");
        System.out.println("STRUK PAKET KOMBINASI PULSA + TOKEN");
        System.out.println("=========================================");
        System.out.println(pulsa);
        System.out.println(token);
        System.out.println("-----------------------------------------");
        System.out.printf("Subtotal      : Rp%,.0f%n", pulsa.getHargaJual() + token.getTotalBayar());
        System.out.printf("Diskon Paket  : -Rp%,.0f%n", diskonPaket);
        System.out.printf("TOTAL BAYAR   : Rp%,.0f%n", getTotalBayar());
        System.out.println("=========================================");
    }

    /**
     * Demo: package ini TIDAK BISA akses:
     * - ProviderPulsa (enum package-private di package pulsa)
     * - GolonganListrik (enum package-private di package token)
     * - new Pulsa(...) (constructor package-private)
     * - new TokenListrik(...) (constructor package-private)
     * - DaftarHargaPulsa.getSemuaPulsa() (method package-private)
     * - TokenListrik.hitungBiayaAdmin() (method package-private)
     * 
     * Kalau mau akses, harus pindah ke package yang sama atau bikin public API.
     * INI TUJUAN PACKAGE: ENCAPSULATION AT PACKAGE LEVEL
     */
}