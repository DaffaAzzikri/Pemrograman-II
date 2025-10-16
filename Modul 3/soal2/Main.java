package soal2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine().trim());

        LinkedList<Negara> daftar = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String namaNegara = scan.nextLine().trim();
            String jenis = scan.nextLine().trim(); 
            String namaPemimpin = scan.nextLine().trim();

            if (jenis.equalsIgnoreCase("monarki")) {
                daftar.add(new Negara(namaNegara, jenis, namaPemimpin));
            } else {
                int tgl  = Integer.parseInt(scan.nextLine().trim());
                int bln  = Integer.parseInt(scan.nextLine().trim()); 
                int thn  = Integer.parseInt(scan.nextLine().trim()); 
                daftar.add(new Negara(namaNegara, jenis, namaPemimpin, tgl, bln, thn));
            }
        }

        for (int i = 0; i < daftar.size(); i++) {
            System.out.println(daftar.get(i).deskripsi());
            if (i != daftar.size() - 1) System.out.println(); 
        }

        scan.close();
    }
}
