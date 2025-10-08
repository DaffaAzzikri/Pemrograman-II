package praktikum2.soal2;

import java.util.Locale;

public class Kopi {
    static {
        Locale.setDefault(Locale.US);
    }

    public String namaKopi;
    public String ukuran;
    public double harga;

    private String pembeli;

    public void setPembeli(String pembeli) { this.pembeli = pembeli; }
    public String getPembeli() { return this.pembeli; }

    public double getPajak() { return 0.11 * this.harga; }

    public void info() {
        System.out.println("Nama Kopi: " + this.namaKopi);
        System.out.println("Ukuran: " + this.ukuran);
        System.out.printf("Harga: Rp. %.1f%n", this.harga);
    }
}
