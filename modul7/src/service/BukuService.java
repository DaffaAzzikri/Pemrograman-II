package service;

import dao.BukuDAO;
import dao.impl.BukuDAOImpl;
import model.Buku;
import java.util.List;

public class BukuService {
    
    private BukuDAO dao = new BukuDAOImpl();

    public List<Buku> getAllBuku() {
        return dao.getAll();
    }

    public void addBuku(String judul, String penulis, double harga, int stok) { 
        dao.add(new Buku(0, judul, penulis, harga, stok));
    }

    public void updateBuku(int id, String judul, String penulis, double harga, int stok) { 
        dao.update(new Buku(id, judul, penulis, harga, stok));
    }

    public void deleteBuku(int id) { 
        dao.delete(id);
    }
}