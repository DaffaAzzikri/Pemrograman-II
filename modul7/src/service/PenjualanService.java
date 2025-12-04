package service;

import dao.PenjualanDAO;
import dao.impl.PenjualanDAOImpl;
import model.Penjualan;
import java.util.List;

public class PenjualanService {
    
    private PenjualanDAO dao = new PenjualanDAOImpl();

    public List<Penjualan> getAllPenjualan() { 
        return dao.getAll();
    }

    public void addPenjualan(int pid, int bid, int jml, double hargaBuku, String tgl) { 
        double total = jml * hargaBuku;
        dao.add(pid, bid, jml, total, tgl);
    }
    
    public void deletePenjualan(int id) { 
        dao.delete(id);
    }
}