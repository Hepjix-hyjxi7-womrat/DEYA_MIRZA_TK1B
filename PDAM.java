/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package her_deyamirza_1004;

/**
 *
 * @author PC
 */
import java.util.Scanner;

public class pdam {

    private String kp;
    private String np;
    private String jp;
    private String tanggal;
    private int meterBulanIni;
    private int meterBulanLalu;
    private int totalBayar;

    public pdam(String kodePembayaran, String namaPelanggan, String jenisPelanggan, String tanggal, int meterBulanIni, int meterBulanLalu) {
        this.kp = kodePembayaran;
        this.np = namaPelanggan;
        this.jp = jenisPelanggan;
        this.tanggal = tanggal;
        this.meterBulanIni = meterBulanIni;
        this.meterBulanLalu = meterBulanLalu;
        this.totalBayar = hitungTotalBayar();
    }

    private int hitungTotalBayar() {
        int meterPakai = meterBulanIni - meterBulanLalu;
        int biaya = 0;

        if (jp.equalsIgnoreCase("GOLD")) {
            if (meterPakai <= 10) {
                biaya = meterPakai * 5000;
            } else if (meterPakai <= 20) {
                biaya = (10 * 5000) + ((meterPakai - 10) * 10000);
            } else {
                biaya = (10 * 5000) + (10 * 10000) + ((meterPakai - 20) * 20000);
            }
        } else if (jp.equalsIgnoreCase("SILVER")) {
            if (meterPakai <= 10) {
                biaya = meterPakai * 4000;
            } else if (meterPakai <= 20) {
                biaya = (10 * 4000) + ((meterPakai - 10) * 8000);
            } else {
                biaya = (10 * 4000) + (10 * 8000) + ((meterPakai - 20) * 10000);
            }
        } else if (jp.equalsIgnoreCase("UMUM")) {
            if (meterPakai <= 10) {
                biaya = meterPakai * 2000;
            } else if (meterPakai <= 20) {
                biaya = (10 * 2000) + ((meterPakai - 10) * 3000);
            } else {
                biaya = (10 * 2000) + (10 * 3000) + ((meterPakai - 20) * 5000);
            }
        }

        return biaya;
    }

    public void tampilkanInfo() {
        System.out.println("Kode Pembayaran: " + kp);
        System.out.println("Nama Pelanggan: " + np);
        System.out.println("Jenis Pelanggan: " + jp);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Meter Bulan Ini: " + meterBulanIni);
        System.out.println("Meter Bulan Lalu: " + meterBulanLalu);
        System.out.println("Total Bayar: " + totalBayar);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Kode Pembayaran: ");
        String kodePembayaran = scanner.nextLine();

        System.out.print("Masukkan Nama Pelanggan: "); 
        String namaPelanggan = scanner.nextLine();

        System.out.print("Masukkan Jenis Pelanggan (GOLD/SILVER/UMUM): ");
        String jenisPelanggan = scanner.nextLine();

        System.out.print("Masukkan Tanggal (tanggal-bulan-tahun): ");
        String tanggal = scanner.nextLine();

        System.out.print("Masukkan Meter Bulan Ini: ");
        int meterBulanIni = scanner.nextInt();

        System.out.print("Masukkan Meter Bulan Lalu: ");
        int meterBulanLalu = scanner.nextInt();

        pdam pdam = new pdam(kodePembayaran, namaPelanggan, jenisPelanggan, tanggal, meterBulanIni, meterBulanLalu);
        pdam.tampilkanInfo();

        scanner.close();
    }
}
