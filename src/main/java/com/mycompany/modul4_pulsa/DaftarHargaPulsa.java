package com.mycompany.modul4_pulsa;

import java.util.ArrayList;
import java.util.List;

/**
 * Daftar harga pulsa - Public API untuk package lain.
 * Demonstrasi: class public yang menyediakan layanan tanpa ekspos detail internal.
 * Package lain hanya butuh tahu: "minta daftar harga" atau "beli pulsa".
 */
public class DaftarHargaPulsa {
    private static final int[] NOMINAL_STANDAR = {5000, 10000, 25000, 50000, 100000};

    // Public method - bisa dipanggil dari package mana saja
    public static void tampilkanSemuaHarga() {
        System.out.println("=========================================");
        System.out.println("DAFTAR HARGA PULSA (Semua Provider)");
        System.out.println("=========================================");

        for (ProviderPulsa provider : ProviderPulsa.values()) {
            System.out.println("\n--- " + provider.getNama() + " (Faktor: " + provider.getFaktorHarga() + ") ---");
            for (int nominal : NOMINAL_STANDAR) {
                Pulsa p = new Pulsa(provider, nominal);
                System.out.printf("  %d -> Rp%,.0f%n", nominal, p.getHargaJual());
            }
        }
    }

    // Public method - beli pulsa (return Pulsa object)
    public static Pulsa beliPulsa(String provider, int nominal) {
        return Pulsa.buatPulsa(provider, nominal);
    }

    // Public method - cari pulsa termurah untuk nominal tertentu
    public static Pulsa cariTermurah(int nominal) {
        Pulsa termurah = null;
        for (ProviderPulsa p : ProviderPulsa.values()) {
            Pulsa kandidat = new Pulsa(p, nominal);
            if (termurah == null || kandidat.getHargaJual() < termurah.getHargaJual()) {
                termurah = kandidat;
            }
        }
        return termurah;
    }

    // Package-private method - hanya untuk testing/internal
    static List<Pulsa> getSemuaPulsa(int nominal) {
        List<Pulsa> list = new ArrayList<>();
        for (ProviderPulsa p : ProviderPulsa.values()) {
            list.add(new Pulsa(p, nominal));
        }
        return list;
    }
}