package praktikum2.soal3;

public class Soal3Main { 
    public static void main(String[] args) { 
        Pegawai p1 = new Pegawai(); 

        // ERROR: Kurang tanda titik koma di akhir baris.
        // p1.nama = "Roi"
        p1.nama = "Roi";

        // ERROR: Field asal sebelumnya bertipe char sehingga tidak bisa menampung String panjang.
        // Tipe telah diperbaiki menjadi String di class Pegawai.
        p1.asal = "Kingdom of Orvel"; 

        // ERROR: Metode setJabatan sebelumnya tidak menerima parameter.
        p1.setJabatan("Assasin"); 

        // Tambahan: agar output sesuai contoh, kita set umur eksplisit (opsional
        // karena sudah diberi default 17 di class Pegawai).
        p1.umur = 17;

        // ERROR: Label teks berbeda dengan contoh output yang diminta ("Nama:" bukan "Nama Pegawai:").
        // System.out.println("Nama Pegawai: " + p1.getNama());
        System.out.println("Nama: " + p1.getNama()); 

        System.out.println("Asal: " + p1.getAsal()); 
        System.out.println("Jabatan: " + p1.jabatan); 

        // ERROR: Contoh output meminta akhiran " tahun".
        // System.out.println("Umur: " + p1.umur);
        System.out.println("Umur: " + p1.umur + " tahun"); 
    } 
} 
