package com.mycompany.modul4_encapsulation;

/**
 * Main class untuk menjalankan demonstrasi Modul 4: Enkapsulasi & Access Modifier.
 * Menunjukkan:
 * 1. Enkapsulasi dengan private fields + getter/setter + validasi (BankAccount)
 * 2. Access Modifier: public, private, protected, default (AccessModifierDemo)
 * 3. Akses package-private dalam package yang sama (SamePackageDemo)
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

        System.out.println("=========================================");
        System.out.println("SELESAI - MODUL 4 ENKAPSULASI");
        System.out.println("=========================================");
    }
}