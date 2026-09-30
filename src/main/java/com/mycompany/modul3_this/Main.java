package com.mycompany.modul3_this;

public class Main {
    public static void main(String[] args) {
        Siswa s = new Siswa();
        s.setNama("Budi");
        s.tampil();
    }
}

class Siswa {
    String nama;

    void setNama(String nama) {
        this.nama = nama;   // this.nama = atribut, nama = parameter
    }

    void tampil() {
        System.out.println("Nama : " + nama);
    }
}

