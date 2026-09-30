package com.mycompany.modul3_method;

public class Main {
    public static void main(String[] args) {
        Kalkulator k = new Kalkulator(); 

        int hasil = k.tambah(5, 3); //fungsi dengan nilai kembalian
        System.out.println("Hasil penjumlahan: " + hasil);

        k.sapa("Cheva"); //prosedur tidak ada nilai kembalian
    }
}
