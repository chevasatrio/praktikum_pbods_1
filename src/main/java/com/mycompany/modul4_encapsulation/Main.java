package com.mycompany.modul4_encapsulation;

import com.mycompany.modul4_paketkombinasi.PaketKombinasi;
import com.mycompany.modul4_pulsa.DaftarHargaPulsa;
import com.mycompany.modul4_pulsa.Pulsa;
import com.mycompany.modul4_subpackage.SubclassDemo;
import com.mycompany.modul4_token.DaftarHargaToken;
import com.mycompany.modul4_token.TokenListrik;

/**
 * Main class untuk menjalankan demonstrasi Modul 4: Enkapsulasi & Access Modifier.
 * Menunjukkan:
 * 1. Enkapsulasi dengan private fields + getter/setter + validasi (BankAccount)
 * 2. Access Modifier: public, private, protected, default (AccessModifierDemo)
 * 3. Akses package-private dalam package yang sama (SamePackageDemo)
 * 4. Akses protected dari subclass di package berbeda (SubclassDemo)
 * 5. PACKAGE SEBAGAI BOUNDARY ENKAPSULASI (contoh nyata: Pulsa & Token Listrik)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("PRAKTIKUM PBO - MODUL 4: ENKAPSULASI");
        System.out.println("=========================================\n");

        // 1. BankAccount - Enkapsulasi penuh
        System.out.println("=== 1. ENKAPSULASI: BankAccount ===");
        BankAccount.showBankInfo();
        System.out.println();

        BankAccount acc1 = new BankAccount("123456", "Rifqi Reissal", 100000);
        acc1.displayAccountInfo();

        BankAccount acc2 = new BankAccount("789012", "Cheva");
        acc2.displayAccountInfo();

        System.out.println("--- Test Validasi ---");
        acc1.deposit(50000);
        acc1.withdraw(30000);
        acc1.withdraw(90000); // gagal: saldo tidak cukup
        acc1.setAccountHolder(""); // gagal: nama kosong
        acc1.setAccountHolder("Rifqi Updated");
        System.out.println("Nama setelah update: " + acc1.getAccountHolder());
        System.out.println("Total rekening: " + BankAccount.getTotalAccounts());
        System.out.println();

        // 2. AccessModifierDemo - 4 access modifier
        System.out.println("=== 2. ACCESS MODIFIER: AccessModifierDemo ===");
        AccessModifierDemo demo = new AccessModifierDemo();
        demo.publicMethod();
        System.out.println("Public field: " + demo.publicField);
        System.out.println("Private field (via getter): " + demo.getPrivateField());
        demo.setPrivateField("Diubah via setter");
        System.out.println("Setelah setter: " + demo.getPrivateField());
        System.out.println("Protected field: " + demo.protectedField);
        demo.protectedMethod();
        System.out.println("Default field: " + demo.defaultField);
        demo.defaultMethod();
        System.out.println();

        // 3. SamePackageDemo - akses dalam package yang sama
        System.out.println("=== 3. PACKAGE-PRIVATE: SamePackageDemo ===");
        SamePackageDemo samePkg = new SamePackageDemo();
        samePkg.testAccess();
        System.out.println();

        // 4. SubclassDemo - protected akses dari subclass beda package
        System.out.println("=== 4. PROTECTED DARI SUBCLASS BEDA PACKAGE: SubclassDemo ===");
        SubclassDemo sub = new SubclassDemo();
        sub.testAccess();
        System.out.println();

        // 5. PACKAGE SEBAGAI BOUNDARY ENKAPSULASI - Contoh Nyata
        System.out.println("=== 5. PACKAGE BOUNDARY: PULSA & TOKEN LISTRIK ===");
        System.out.println("--- Daftar Harga Pulsa ---");
        DaftarHargaPulsa.tampilkanSemuaHarga();
        System.out.println();

        System.out.println("--- Beli Pulsa via Public API ---");
        Pulsa p1 = DaftarHargaPulsa.beliPulsa("Telkomsel", 25000);
        Pulsa p2 = DaftarHargaPulsa.beliPulsa("XL", 50000);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("Termurah 25k: " + DaftarHargaPulsa.cariTermurah(25000));
        System.out.println();

        System.out.println("--- Daftar Harga Token Listrik ---");
        DaftarHargaToken.tampilkanHargaStandar();
        System.out.println();

        System.out.println("--- Beli Token via Public API ---");
        TokenListrik t1 = DaftarHargaToken.beliToken("R1 900 VA", 10);
        TokenListrik t2 = DaftarHargaToken.beliToken("R2 3500-5500 VA", 20);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println("Estimasi kWh Rp50k untuk R1 900 VA: " 
                + DaftarHargaToken.estimasiKwh("R1 900 VA", 50000) + " kWh");
        System.out.println();

        System.out.println("--- Paket Kombinasi (Package Lain Menggunakan Public API) ---");
        PaketKombinasi paket = new PaketKombinasi("Indosat", 10000, "R1 1300 VA", 15);
        paket.printStruk();
        System.out.println();

        System.out.println("=== PENJELASAN KONSEP PACKAGE ===");
        System.out.println("Package pulsa & token MENYEMBUNYIKAN:");
        System.out.println("  - Enum ProviderPulsa, GolonganListrik (package-private)");
        System.out.println("  - Constructor Pulsa, TokenListrik (package-private)");
        System.out.println("  - Helper method internal (package-private)");
        System.out.println();
        System.out.println("Package lain (paketkombinasi) HANYA BISA:");
        System.out.println("  - Panggil DaftarHargaPulsa.beliPulsa()");
        System.out.println("  - Panggil DaftarHargaToken.beliToken()");
        System.out.println("  - Terima object Pulsa/TokenListrik (public getter)");
        System.out.println();
        System.out.println("INI TUJUAN PACKAGE: Enkapsulasi di level package!");
        System.out.println("=========================================");
        System.out.println("SELESAI - MODUL 4 ENKAPSULASI");
        System.out.println("=========================================");
    }
}