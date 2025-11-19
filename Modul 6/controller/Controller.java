package controller;

import model.Mahasiswa; 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

    @FXML
    private TableView<Mahasiswa> tableMahasiswa; 
    @FXML
    private TableColumn<Mahasiswa, String> colNim; 
    @FXML
    private TableColumn<Mahasiswa, String> colNama; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        ObservableList<Mahasiswa> list = FXCollections.observableArrayList(
            new Mahasiswa(1, "Daffa Azzikri", "2410817110002"),
            new Mahasiswa(2, "Rizqan Karim", "2410817110003"),
            new Mahasiswa(3, "Sio", "2410817110004"),      
            new Mahasiswa(4, "Andre", "2410817110005"),   
            new Mahasiswa(5, "Gete", "2410817110006"),
            new Mahasiswa(6, "Irfan Saja", "2410817110007"),
            new Mahasiswa(7, "Alif", "2410817110008"),
            new Mahasiswa(8, "Asep", "2410817110009"),
            new Mahasiswa(9, "Atha", "241081711010"),
            new Mahasiswa(10, "Udin", "241081711011")
        );

        tableMahasiswa.setItems(list);
    }
}