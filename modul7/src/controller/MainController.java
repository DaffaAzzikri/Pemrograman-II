package controller;

import javafx.collections.FXCollections;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import model.*; 
import service.*; 
import util.AlertHelper;

public class MainController implements Initializable {
    @FXML private TextField txtPelangganNama, txtPelangganEmail, txtPelangganTelepon;
    @FXML private TableView<Pelanggan> tablePelanggan;
    @FXML private TableColumn<Pelanggan, String> colPelangganNama, colPelangganEmail, colPelangganTelp;

    @FXML private TextField txtBukuJudul, txtBukuPenulis, txtBukuHarga, txtBukuStok;
    @FXML private TableView<Buku> tableBuku;
    @FXML private TableColumn<Buku, String> colBukuJudul, colBukuPenulis;
    @FXML private TableColumn<Buku, Double> colBukuHarga; 
    @FXML private TableColumn<Buku, Integer> colBukuStok;

    @FXML private ComboBox<Pelanggan> cbJualPelanggan;
    @FXML private ComboBox<Buku> cbJualBuku;
    @FXML private TextField txtJualJumlah;
    @FXML private DatePicker dateJualTanggal;
    @FXML private TableView<Penjualan> tablePenjualan;
    @FXML private TableColumn<Penjualan, String> colJualTanggal, colJualPelanggan, colJualBuku;
    @FXML private TableColumn<Penjualan, Double> colJualTotal;

    private PelangganService plgService = new PelangganService();
    private BukuService bukuService = new BukuService();
    private PenjualanService jualService = new PenjualanService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTableColumns();
        setupTableListener();
        loadAllData();
    }

    private void setupTableColumns() {
        // Pelanggan
        colPelangganNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colPelangganEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPelangganTelp.setCellValueFactory(new PropertyValueFactory<>("telepon"));

        // Buku
        colBukuJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
        colBukuPenulis.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        colBukuHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colBukuStok.setCellValueFactory(new PropertyValueFactory<>("stok"));

        // Penjualan
        colJualTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colJualPelanggan.setCellValueFactory(new PropertyValueFactory<>("namaPelanggan"));
        colJualBuku.setCellValueFactory(new PropertyValueFactory<>("judulBuku"));
        colJualTotal.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
    }

    private void loadAllData() {
        tablePelanggan.setItems(FXCollections.observableArrayList(plgService.getAllPelanggan()));
        tableBuku.setItems(FXCollections.observableArrayList(bukuService.getAllBuku()));
        tablePenjualan.setItems(FXCollections.observableArrayList(jualService.getAllPenjualan()));
        cbJualPelanggan.setItems(FXCollections.observableArrayList(plgService.getAllPelanggan()));
        cbJualBuku.setItems(FXCollections.observableArrayList(bukuService.getAllBuku()));
    }
    
    private void setupTableListener() {
        tablePelanggan.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtPelangganNama.setText(newVal.getNama());
                txtPelangganEmail.setText(newVal.getEmail());
                txtPelangganTelepon.setText(newVal.getTelepon());
            }
        });

        tableBuku.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtBukuJudul.setText(newVal.getJudul());
                txtBukuPenulis.setText(newVal.getPenulis());
                txtBukuHarga.setText(String.valueOf(newVal.getHarga()).replace(".0", ""));
                txtBukuStok.setText(String.valueOf(newVal.getStok()));
            }
        });
    }
    
    //PELANGGAN
    @FXML private void handleTambahPelanggan() {
        String n = txtPelangganNama.getText();
        String e = txtPelangganEmail.getText();
        String t = txtPelangganTelepon.getText();

        if (AlertHelper.isEmpty(n, e, t)) {
            AlertHelper.showError("Data Kurang", "Isi semua data pelanggan dulu!");
            return;
        }
        if (!t.matches("\\d+")) {
            AlertHelper.showError("Format Salah", "Telepon harus angka doang!");
            return;
        }
        
        plgService.addPelanggan(n, e, t);
        loadAllData();
        clearPlg();
        AlertHelper.showInfo("Sukses", "Data Pelanggan Disimpan!");
    }
    
    @FXML private void handleEditPelanggan() {
        Pelanggan sel = tablePelanggan.getSelectionModel().getSelectedItem();
        if (sel == null) { AlertHelper.showError("Error", "Pilih data di tabel dulu!"); return; }
        
        String n = txtPelangganNama.getText();
        String e = txtPelangganEmail.getText();
        String t = txtPelangganTelepon.getText();
        
        if (AlertHelper.isEmpty(n, e, t)) { AlertHelper.showError("Error", "Data gak boleh kosong!"); return; }
        
        plgService.updatePelanggan(sel.getId(), n, e, t);
        loadAllData();
        clearPlg();
        AlertHelper.showInfo("Sukses", "Data Pelanggan Diupdate!");
    }

    @FXML private void handleHapusPelanggan() {
        Pelanggan sel = tablePelanggan.getSelectionModel().getSelectedItem();
        if(sel != null) {
            plgService.deletePelanggan(sel.getId());
            loadAllData();
            clearPlg();
            AlertHelper.showInfo("Info", "Data dihapus.");
        } else {
            AlertHelper.showError("Error", "Pilih data dulu!");
        }
    }
    
    //BUKU
    @FXML private void handleTambahBuku() {
        String j = txtBukuJudul.getText();
        String p = txtBukuPenulis.getText();
        String hStr = txtBukuHarga.getText();
        String sStr = txtBukuStok.getText();

        if (AlertHelper.isEmpty(j, p, hStr, sStr)) {
            AlertHelper.showError("Data Kurang", "Lengkapi data buku!");
            return;
        }

        try {
            double h = Double.parseDouble(hStr);
            int s = Integer.parseInt(sStr);
            
            bukuService.addBuku(j, p, h, s);
            loadAllData();
            clearBk();
            AlertHelper.showInfo("Sukses", "Buku disimpan!");
        } catch (NumberFormatException ex) {
            AlertHelper.showError("Error", "Harga/Stok harus angka!");
        }
    }
    
    @FXML private void handleEditBuku() {
        Buku sel = tableBuku.getSelectionModel().getSelectedItem();
        if (sel == null) { AlertHelper.showError("Error", "Pilih buku dulu!"); return; }
        
        try {
            bukuService.updateBuku(sel.getId(), txtBukuJudul.getText(), txtBukuPenulis.getText(), 
                Double.parseDouble(txtBukuHarga.getText()), Integer.parseInt(txtBukuStok.getText()));
            loadAllData();
            clearBk();
            AlertHelper.showInfo("Sukses", "Buku Diupdate!");
        } catch (NumberFormatException ex) {
            AlertHelper.showError("Error", "Harga/Stok harus angka!");
        }
    }

    @FXML private void handleHapusBuku() {
        Buku sel = tableBuku.getSelectionModel().getSelectedItem();
        if(sel != null) {
            bukuService.deleteBuku(sel.getId());
            loadAllData();
            clearBk();
            AlertHelper.showInfo("Info", "Buku dihapus.");
        } else {
            AlertHelper.showError("Error", "Pilih buku dulu!");
        }
    }
    
    //TRANSAKSI
    @FXML private void handleTambahTransaksi() {
        Pelanggan p = cbJualPelanggan.getValue();
        Buku b = cbJualBuku.getValue();
        String jmlStr = txtJualJumlah.getText();
        var tgl = dateJualTanggal.getValue();

        if (p == null || b == null || AlertHelper.isEmpty(jmlStr) || tgl == null) {
            AlertHelper.showError("Data Kurang", "Pilih Pelanggan, Buku, Tanggal dan Jumlah!");
            return;
        }

        try {
            int jml = Integer.parseInt(jmlStr);
            if (jml > b.getStok()) {
                AlertHelper.showError("Stok Kurang", "Stok cuma sisa " + b.getStok());
                return;
            }

            jualService.addPenjualan(p.getId(), b.getId(), jml, b.getHarga(), tgl.toString());
            loadAllData();
            txtJualJumlah.clear();
            AlertHelper.showInfo("Sukses", "Transaksi Berhasil!");
        } catch (NumberFormatException e) {
            AlertHelper.showError("Error", "Jumlah beli harus angka!");
        }
    }

    private void clearPlg() { txtPelangganNama.clear(); txtPelangganEmail.clear(); txtPelangganTelepon.clear(); }
    private void clearBk() { txtBukuJudul.clear(); txtBukuPenulis.clear(); txtBukuHarga.clear(); txtBukuStok.clear(); }
}