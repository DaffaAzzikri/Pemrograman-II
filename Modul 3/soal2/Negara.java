package soal2;

import java.util.HashMap;

public class Negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private Integer tanggal;
    private Integer bulan;
    private Integer tahun;

    private static final HashMap<Integer, String> NAMA_BULAN = new HashMap<>();
    static {
        NAMA_BULAN.put(1, "Januari");
        NAMA_BULAN.put(2, "Februari");
        NAMA_BULAN.put(3, "Maret");
        NAMA_BULAN.put(4, "April");
        NAMA_BULAN.put(5, "Mei");
        NAMA_BULAN.put(6, "Juni");
        NAMA_BULAN.put(7, "Juli");
        NAMA_BULAN.put(8, "Agustus");
        NAMA_BULAN.put(9, "September");
        NAMA_BULAN.put(10, "Oktober");
        NAMA_BULAN.put(11, "November");
        NAMA_BULAN.put(12, "Desember");
    }

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin,
                  int tanggal, int bulan, int tahun) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
    }

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
        this(nama, jenisKepemimpinan, namaPemimpin, 0, 0, 0);
        this.tanggal = null;
        this.bulan = null;
        this.tahun = null;
    }
    
//getter setter
    public String getNama() { return nama; }
    public String getJenisKepemimpinan() { return jenisKepemimpinan; }
    public String getNamaPemimpin() { return namaPemimpin; }
    public Integer getTanggal() { return tanggal; }
    public Integer getBulan() { return bulan; }
    public Integer getTahun() { return tahun; }
    
    private static String Case(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].isEmpty()) continue;
            sb.append(Character.toUpperCase(parts[i].charAt(0)));
            if (parts[i].length() > 1) sb.append(parts[i].substring(1).toLowerCase());
            if (i < parts.length - 1) sb.append(' ');
        }
        return sb.toString();
    }

    public String deskripsi() {
        StringBuilder out = new StringBuilder();

        String jabatan;
        if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
            jabatan = "Raja"; 
        } else {
            jabatan = Case(jenisKepemimpinan);
        }

        out.append("Negara ").append(nama)
           .append(" mempunyai ").append(jabatan)
           .append(" bernama ").append(namaPemimpin);

        if (!jenisKepemimpinan.equalsIgnoreCase("monarki")
            && tanggal != null && bulan != null && tahun != null) {
            String namaBulan = NAMA_BULAN.getOrDefault(bulan, "BulanTidakValid");
            out.append("\nDeklarasi Kemerdekaan pada Tanggal ")
               .append(tanggal).append(' ').append(namaBulan)
               .append(' ').append(tahun);
        }

        return out.toString();
    }
}
