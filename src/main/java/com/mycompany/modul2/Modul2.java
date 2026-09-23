/*
 * Praktikum PBO - Modul 2: Intro Pemrograman Berorientasi Objek
 * Nama: Rifqi Reissal Arasy
 * NIM : 1201230038
 */

package com.mycompany.modul2;

/**
 * Class utama Modul 2 - versi ringkas, hanya pokok yang paling
 * sering dipakai dan paling sering jadi sumber error praktikan:
 * variabel & tipe data, konstanta, array, operator aritmatika &
 * relasional, if-else, switch, dan perulangan.
 */
public class Modul2 {

    public static void main(String[] args) {

        // ============================================================
        // 2.1 TIPE DATA DAN VARIABEL
        // ============================================================

        // Ini variabel sederhana dengan tipe data primitif.
        // int = bilangan bulat, double = bilangan desimal,
        // char = satu karakter, boolean = true/false.
        int umur = 20;
        double ipk = 3.78;
        char nilaiHuruf = 'A';
        boolean lulus = true;

        // String = tipe referensi (bukan primitif), untuk teks.
        String nama = "Rifqi Reissal Arasy";

        System.out.println("=== 2.1 Tipe Data dan Variabel ===");
        System.out.println("Nama : " + nama);
        System.out.println("Umur : " + umur);
        System.out.println("IPK  : " + ipk);
        System.out.println("Nilai: " + nilaiHuruf + ", Lulus: " + lulus);
        System.out.println();

        // ============================================================
        // 2.2 KONSTANTA
        // ============================================================

        // Ini konstanta - variabel final yang TIDAK BISA diubah
        // setelah dideklarasi. Konvensi nama: HURUF_BESAR.
        final double PHI = 3.14159;

        double jariJari = 7.0;
        double luasLingkaran = PHI * jariJari * jariJari;

        System.out.println("=== 2.2 Konstanta ===");
        System.out.println("Luas lingkaran (r=7): " + luasLingkaran);
        System.out.println();

        // ============================================================
        // 2.3 VARIABEL ARRAY
        // ============================================================

        System.out.println("=== 2.3 Variabel Array ===");

        // Deklarasi + isi langsung (cara paling sering dipakai).
        // Index array dimulai dari 0: angka[0] = elemen pertama.
        int[] angka = {10, 20, 30, 40, 50};
        System.out.println("Elemen pertama angka[0]: " + angka[0]);
        System.out.println("Elemen terakhir angka[4]: " + angka[4]);

        // Array 2 dimensi: seperti tabel (baris x kolom).
        int[][] matriks = {
            {1, 2, 3},
            {4, 5, 6}
        };
        // matriks[baris][kolom] -> matriks[1][2] = baris ke-2, kolom ke-3.
        System.out.println("Matriks [1][2]: " + matriks[1][2]);
        System.out.println();

        // ============================================================
        // 2.4.1 OPERATOR (yang paling sering dipakai)
        // ============================================================

        System.out.println("=== 2.4.1 Operator ===");
        int a = 15;
        int b = 4;

        // Operator aritmatika dasar.
        System.out.println("a + b = " + (a + b));   // penjumlahan
        System.out.println("a / b = " + (a / b));   // pembagian int/int hasilnya int (3, bukan 3.75)
        System.out.println("a % b = " + (a % b));   // sisa bagi: 15 % 4 = 3

        // Operator relasional: hasilnya true/false.
        System.out.println("a > b  : " + (a > b));
        System.out.println("a == b : " + (a == b));
        System.out.println();

        // ============================================================
        // BONUS: operator yang jarang dipakai, cukup tahu ada aja
        // ============================================================

        System.out.println("=== Bonus: cukup tahu ===");

        // Increment & decrement: naik/turun 1.
        a++;   // sama dengan a = a + 1
        System.out.println("a++ -> a = " + a);

        // Assignment shortcut: += -= *= /= %= (ekivalen d = d + nilai).
        int d = 10;
        d += 5;   // sama dengan d = d + 5
        System.out.println("d += 5 -> d = " + d);
        System.out.println();

        // ============================================================
        // 2.4.2 PERNYATAAN KONDISIONAL
        // ============================================================

        System.out.println("=== 2.4.2 Kondisional ===");

        // if - else if - else: pilih blok sesuai kondisi yang terpenuhi.
        int nilaiUjian = 85;
        if (nilaiUjian >= 90) {
            System.out.println("Grade A");
        } else if (nilaiUjian >= 80) {
            System.out.println("Grade B");   // 85 masuk sini
        } else {
            System.out.println("Grade C");
        }

        // switch-case: untuk membandingkan satu variabel
        // dengan banyak nilai tetap.
        int hariKe = 3;
        switch (hariKe) {
            case 1:
                System.out.println("Senin");
                break;   // break wajib, kalau lupa semua case di bawahnya ikut jalan
            case 2:
                System.out.println("Selasa");
                break;
            case 3:
                System.out.println("Rabu");   // output: Rabu
                break;
            default:
                System.out.println("Tidak dikenal");
                break;
        }

        // Ternary: if-else singkat satu baris (cukup tahu).
        // Sintaks: kondisi ? nilaiJikaTrue : nilaiJikaFalse
        int nilai = 3 > 2 ? 4 : 5;   // 3 > 2 true, jadi nilai = 4.
        System.out.println("Ternary: nilai = " + nilai);
        System.out.println();

        // ============================================================
        // 2.4.3 PERULANGAN
        // ============================================================

        System.out.println("=== 2.4.3 Perulangan ===");

        // for: jumlah pengulangan sudah diketahui.
        System.out.print("For 1-5  : ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // while: kondisi dicek dulu sebelum blok jalan.
        int counter = 1;
        System.out.print("While 1-5: ");
        while (counter <= 5) {
            System.out.print(counter + " ");
            counter++;   // lupa counter++ = infinite loop (error paling sering!)
        }
        System.out.println();

        // do-while: blok dijamin jalan minimal 1 kali.
        int angkaDo = 1;
        System.out.print("Do-While : ");
        do {
            System.out.print(angkaDo + " ");
            angkaDo++;
        } while (angkaDo <= 5);
        System.out.println();

        // Nested loop untuk menelusuri array 2D.
        System.out.println("Isi matriks:");
        for (int i = 0; i < matriks.length; i++) {
            // matriks.length = jumlah baris.
            for (int j = 0; j < matriks[i].length; j++) {
                // matriks[i].length = jumlah kolom di baris ke-i.
                System.out.print(matriks[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // ============================================================
        // 2.5 COMPILE, RUN, DAN JAR FILE (penjelasan)
        // ============================================================
        // Compile : javac mengubah source code menjadi byte code (.class).
        // Run     : java namaFile menjalankan byte code di Java VM.
        // Jar     : mvn package menghasilkan file .jar di folder target/.
        // ============================================================
    }
}
