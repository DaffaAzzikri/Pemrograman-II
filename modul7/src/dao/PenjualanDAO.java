package dao;
import model.Penjualan;
import java.util.List;

public interface PenjualanDAO {
    List<Penjualan> getAll();
    void add(int pid, int bid, int jml, double total, String tgl);
    void delete(int id); 
}