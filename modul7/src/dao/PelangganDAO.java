package dao;
import model.Pelanggan;
import java.util.List;

public interface PelangganDAO {
    List<Pelanggan> getAll();
    void add(Pelanggan p);
    void update(Pelanggan p);
    void delete(int id);
}