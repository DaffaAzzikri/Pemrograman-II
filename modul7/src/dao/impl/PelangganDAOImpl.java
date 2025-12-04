package dao.impl;

import model.Pelanggan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.PelangganDAO;
import util.DatabaseConnection;

public class PelangganDAOImpl implements PelangganDAO {
    
    @Override
    public List<Pelanggan> getAll() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Pelanggan(
                    rs.getInt("pelanggan_id"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("telepon")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void add(Pelanggan p) {
        String sql = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getNama());
            pstmt.setString(2, p.getEmail());
            pstmt.setString(3, p.getTelepon());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void update(Pelanggan p) {
        String sql = "UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE pelanggan_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getNama());
            pstmt.setString(2, p.getEmail());
            pstmt.setString(3, p.getTelepon());
            pstmt.setInt(4, p.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM pelanggan WHERE pelanggan_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}