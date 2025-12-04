package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.AlertHelper;	

public class DatabaseConnection {
 private static final String URL = "jdbc:mysql://localhost:3306/praktikum7";
 private static final String USER = "root";
 private static final String PASSWORD = ""; 

 public static Connection getConnection() {
     try {
         return DriverManager.getConnection(URL, USER, PASSWORD);
     } catch (SQLException e) {
         AlertHelper.showError("Database Error", "Koneksi ke MYSQL GAGAL! Cek XAMPP.");
         return null;
     }
 }
}