package dao.impl;

import dao.PenjualanDAO;
import model.Penjualan;
import util.DatabaseConnection;
import util.AlertHelper;
import java.sql.*;
import java.util.*;

public class PenjualanDAOImpl implements PenjualanDAO {

    @Override
    public List<Penjualan> getAll() {
        List<Penjualan> list = new ArrayList<>();
        String sql = "SELECT p.penjualan_id, p.jumlah, p.total_harga, p.tanggal, pel.nama, b.judul " +
                     "FROM penjualan p " +
                     "JOIN pelanggan pel ON p.pelanggan_id = pel.pelanggan_id " +
                     "JOIN buku b ON p.buku_id = b.buku_id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Penjualan(rs.getInt(1), rs.getInt(2), rs.getDouble(3), 
                                       rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void add(int pid, int bid, int jml, double total, String tgl) {
        String sql = "INSERT INTO penjualan (pelanggan_id, buku_id, jumlah, total_harga, tanggal) VALUES (?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pid); 
            ps.setInt(2, bid); 
            ps.setInt(3, jml); 
            ps.setDouble(4, total); 
            ps.setString(5, tgl);
            ps.executeUpdate();
        } catch (SQLException e) { 
            AlertHelper.showError("Transaksi Gagal", e.getMessage()); 
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM penjualan WHERE penjualan_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) { 
            AlertHelper.showError("Gagal Hapus Transaksi", e.getMessage()); 
        }
    }
}