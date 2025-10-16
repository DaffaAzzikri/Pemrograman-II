package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Dadu {

    private int nilai;

    public Dadu() {
        acakNilai(); 
    }

        public void acakNilai() {
        setNilai((int)(Math.random() * 6) + 1);
    }

    // Getter
    public int getNilai() {
        return nilai;
    }

    // Setter 
    public void setNilai(int nilai) {
        if (nilai < 1 || nilai > 6) {
            throw new IllegalArgumentException("Nilai dadu harus 1–6.");
        }
        this.nilai = nilai;
    }

    public static void jalankan() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan Jumlah Dadu : ");
        int n = scan.nextInt();

        if (n <= 0) {
            System.out.println("Jumlah dadu harus lebih dari 0.");
            scan.close();
            return;
        }

        LinkedList<Dadu> daftar = new LinkedList<>();
        int total = 0;

        for (int i = 0; i < n; i++) {
            Dadu d = new Dadu();
            daftar.add(d);
            int nilai = d.getNilai();
            total += nilai;
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilai);
        }

        System.out.println("Total nilai dadu keseluruhan " + total);
        scan.close();
    }
}