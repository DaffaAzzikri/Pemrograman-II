package praktikum2.soal3;

// ERROR: Nama class tidak sesuai dengan nama file (Employee seharusnya Pegawai). 
// public class harus sama dengan nama file.
// public class Employee {
public class Pegawai {
    public String nama;

    // ERROR: Tipe data asal salah (char), karena ingin menampung teks "Kingdom of Orvel".
    // public char asal;
    public String asal;

    public String jabatan;

    // ERROR: Nilai umur tidak pernah di-set di main. Buat nilai default 17
    public int umur = 17;

    public String getNama() {
        return nama;
    }

    // ERROR: Tipe pengembalian (return type) tidak konsisten dengan deklarasi field.
    // public String getAsal() { return asal; }  // sebelumnya asal bertipe char, sekarang String
    public String getAsal() {
        return asal;
    }

    // ERROR: setJabatan tanpa parameter dan menggunakan variabel j yang tidak dideklarasikan.
    // public void setJabatan() { this.jabatan = j; }
    public void setJabatan(String j) {
        this.jabatan = j;
    }
}
