package model;
public class Penjualan {
    private int id, jumlah; 
    private double totalHarga; 
    private String tanggal, namaPelanggan, judulBuku;
    
    public Penjualan(int id, int j, double t, String d, String np, String jb) {
        this.id=id; 
        this.jumlah=j; 
        this.totalHarga=t; 
        this.tanggal=d; 
        this.namaPelanggan=np; 
        this.judulBuku=jb;
    }
    
    //Getter
    public int getId() { return id; }
    public int getJumlah() { return jumlah; }
    public double getTotalHarga() { return totalHarga; }
    public String getTanggal() { return tanggal; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public String getJudulBuku() { return judulBuku; }
}