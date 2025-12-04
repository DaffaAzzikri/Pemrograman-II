package dao;
import model.Buku;
import java.util.List;

public interface BukuDAO {
    List<Buku> getAll();
    void add(Buku b);
    void update(Buku b);
    void delete(int id);
}