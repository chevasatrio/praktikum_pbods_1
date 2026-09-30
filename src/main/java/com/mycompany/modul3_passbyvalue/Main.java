package com.mycompany.modul3_passbyvalue;

public class Main {
    public static void main(String[] args) {
        int angka = 10;
        ubahAngka(angka);
        System.out.println("Angka : " + angka); // tetap 10

        Kotak kotak = new Kotak();
        kotak.isi = 10;
        ubahKotak(kotak);
        System.out.println("Isi kotak : " + kotak.isi); // menjadi 11
    }

    static void ubahAngka(int x) {
        x = x + 1;
    }

    static void ubahKotak(Kotak k) {
        k.isi = k.isi + 1;
    }
}

class Kotak {
    int isi;
}
