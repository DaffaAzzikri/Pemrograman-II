package soal3;

public class Mahasiswa {
    private final String nama;
    private final String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter
    public String getNama() { return nama; }
    public String getNim()  { return nim;  }
}
