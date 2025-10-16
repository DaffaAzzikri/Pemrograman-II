package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int findIndexByNim(ArrayList<Mahasiswa> list, String nim) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNim().equals(nim)) return i;
        }
        return -1;
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
        System.out.println("3. Cari Mahasiswa berdasarkan NIM");
        System.out.println("4. Tampilkan Daftar Mahasiswa");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {
        ArrayList<Mahasiswa> daftar = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                printMenu();
                System.out.print("Pilihan: ");
                String in = sc.nextLine().trim();
                if (in.isEmpty()) continue;

                int pilih;
                try {
                    pilih = Integer.parseInt(in);
                } catch (NumberFormatException e) {
                    System.out.println("Pilihan harus angka.");
                    System.out.println();
                    continue;
                }

                switch (pilih) {
                    case 1: { 
                        System.out.print("Masukkan Nama Mahasiswa: ");
                        String nama = sc.nextLine();

                        String nim;
                        while (true) {
                            System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                            nim = sc.nextLine().trim();
                            if (nim.isEmpty()) {
                                System.out.println("NIM tidak boleh kosong.");
                                continue;
                            }
                            if (findIndexByNim(daftar, nim) != -1) {
                                System.out.println("NIM sudah terdaftar, masukkan NIM lain.");
                                continue;
                            }
                            break;
                        }

                        daftar.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa " + nama + " ditambahkan.");
                        System.out.println();
                        break;
                    }

                    case 2: { 
                        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                        String nimHapus = sc.nextLine().trim();
                        int idx = findIndexByNim(daftar, nimHapus);
                        if (idx != -1) {
                            daftar.remove(idx);
                            System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
                        } else {
                            System.out.println("Data dengan NIM tersebut tidak ditemukan.");
                        }
                        System.out.println();
                        break;
                    }

                    case 3: { 
                        System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                        String nimCari = sc.nextLine().trim();
                        int idx = findIndexByNim(daftar, nimCari);
                        if (idx != -1) {
                            Mahasiswa m = daftar.get(idx);
                            System.out.println("Data ditemukan:");
                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                        } else {
                            System.out.println("Data tidak ditemukan.");
                        }
                        System.out.println();
                        break;
                    }

                    case 4: { 
                        System.out.println("Daftar Mahasiswa:");
                        if (daftar.isEmpty()) {
                            System.out.println("(kosong)");
                        } else {
                            for (Mahasiswa m : daftar) {
                                System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                            }
                        }
                        System.out.println();
                        break;
                    }

                    case 0: 
                        System.out.println("Terima kasih!");
                        daftar.clear(); 
                        return;

                    default:
                        System.out.println("Pilihan tidak tersedia.");
                        System.out.println();
                }
            }
        }
    }
}
