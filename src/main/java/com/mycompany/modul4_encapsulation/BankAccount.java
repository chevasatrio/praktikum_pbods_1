package com.mycompany.modul4_encapsulation;

/**
 * Contoh enkapsulasi dengan access modifier private dan getter/setter.
 * Menunjukkan cara menyembunyikan data internal (private) dan menyediakan akses
 * terkendali melalui method public.
 */
public class BankAccount {
    // Private attributes - hanya bisa diakses dalam class ini
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private static final double MIN_BALANCE = 50000.0; // Static final constant
    private static int totalAccounts = 0; // Static variable

    // Default constructor
    public BankAccount() {
        this.accountNumber = "000000";
        this.accountHolder = "Unknown";
        this.balance = 0.0;
        totalAccounts++;
    }

    // Constructor overloading - constructor dengan parameter
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = (initialBalance >= MIN_BALANCE) ? initialBalance : MIN_BALANCE;
        totalAccounts++;
    }

    // Constructor overloading - tanpa initial balance
    public BankAccount(String accountNumber, String accountHolder) {
        this(accountNumber, accountHolder, MIN_BALANCE);
    }

    // Getter methods (accessor)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Setter methods (mutator) - dengan validasi
    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        } else {
            System.out.println("Error: Nama pemegang rekening tidak boleh kosong!");
        }
    }

    // Method untuk deposit (setor tunai)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit berhasil: Rp" + amount + ", Saldo: Rp" + balance);
        } else {
            System.out.println("Error: Jumlah deposit harus positif!");
        }
    }

    // Method untuk withdraw (tarik tunai)
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Jumlah penarikan harus positif!");
        } else if (amount > balance) {
            System.out.println("Error: Saldo tidak mencukupi! Saldo: Rp" + balance);
        } else if ((balance - amount) < MIN_BALANCE) {
            System.out.println("Error: Saldo minimal Rp" + MIN_BALANCE + " harus dijaga!");
        } else {
            balance -= amount;
            System.out.println("Penarikan berhasil: Rp" + amount + ", Saldo: Rp" + balance);
        }
    }

    // Static method untuk akses static variable
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Static method untuk info bank
    public static void showBankInfo() {
        System.out.println("=== Bank XYZ - Sistem Rekening ===");
        System.out.println("Total rekening aktif: " + totalAccounts);
        System.out.println("Saldo minimal: Rp" + MIN_BALANCE);
    }

    // Method untuk display info rekening
    public void displayAccountInfo() {
        System.out.println("=== Info Rekening ===");
        System.out.println("No. Rekening: " + accountNumber);
        System.out.println("Pemegang: " + accountHolder);
        System.out.println("Saldo: Rp" + balance);
        System.out.println("=====================");
    }
}