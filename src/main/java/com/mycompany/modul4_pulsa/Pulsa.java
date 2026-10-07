package com.mycompany.modul4_pulsa;

/**
 * Class Pulsa - merepresentasikan produk pulsa.
 * Demonstrasi: class public, tapi pakai enum package-private (ProviderPulsa)
 * sebagai implementation detail yang tidak diekspos ke package lain.
 */
public class Pulsa {
    private final ProviderPulsa provider;
    private final int nominal; // nominal asli (misal: 10000, 25000, 50000)
    private final double hargaJual; // harga jual ke customer

    // Package-private constructor - hanya bisa dipanggil dari package yang sama
    // Ini mencegah package lain membuat Pulsa sembarangan, harus lewat factory
    Pulsa(ProviderPulsa provider, int nominal) {
        this.provider = provider;
        this.nominal = nominal;
        // Harga jual = nominal * faktor provider + margin 5%
        this.hargaJual = nominal * provider.getFaktorHarga() * 1.05;
    }

    // Public factory method - ini yang diekspos ke package lain
    public static Pulsa buatPulsa(String namaProvider, int nominal) {
        ProviderPulsa provider = cariProvider(namaProvider);
        if (provider == null) {
            throw new IllegalArgumentException("Provider tidak dikenal: " + namaProvider);
        }
        if (nominal < 5000 || nominal > 500000) {
            throw new IllegalArgumentException("Nominal harus 5000 - 500000");
        }
        return new Pulsa(provider, nominal);
    }

    // Package-private helper - hanya untuk package ini
    static ProviderPulsa cariProvider(String nama) {
        for (ProviderPulsa p : ProviderPulsa.values()) {
            if (p.getNama().equalsIgnoreCase(nama)) {
                return p;
            }
        }
        return null;
    }

    // Getter public - read-only access
    public ProviderPulsa getProvider() { return provider; }
    public int getNominal() { return nominal; }
    public double getHargaJual() { return hargaJual; }
    public double getHargaBeli() { return nominal * provider.getFaktorHarga(); }
    public double getKeuntungan() { return hargaJual - getHargaBeli(); }

    @Override
    public String toString() {
        return String.format("%s %d - Harga Jual: Rp%,.0f (Beli: Rp%,.0f, Untung: Rp%,.0f)",
                provider.getNama(), nominal, hargaJual, getHargaBeli(), getKeuntungan());
    }
}