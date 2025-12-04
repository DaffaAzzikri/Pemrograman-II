package service;

import dao.PelangganDAO;
import dao.impl.PelangganDAOImpl;
import model.Pelanggan;
import java.util.List;

public class PelangganService {
    
    private PelangganDAO dao = new PelangganDAOImpl();

    public List<Pelanggan> getAllPelanggan() {
        return dao.getAll();
    }

    public void addPelanggan(String nama, String email, String telp) {
        dao.add(new Pelanggan(0, nama, email, telp));
    }

    public void updatePelanggan(int id, String nama, String email, String telp) {
        dao.update(new Pelanggan(id, nama, email, telp));
    }

    public void deletePelanggan(int id) {
        dao.delete(id);
    }
}