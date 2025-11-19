module praktikum6 { // <-- Ganti 'NamaProjectLu' sama nama project di Eclipse lu
	requires javafx.controls;
	requires javafx.fxml;
    requires javafx.graphics;
	
	// Buka akses ke package application (buat Main class)
	opens application to javafx.graphics, javafx.fxml;
    
    // Buka akses ke package Controller (biar FXML bisa baca Controller)
    opens controller to javafx.fxml;
    
    // Buka akses ke package Model (biar TableView bisa baca Getter Mahasiswa)
    opens model to javafx.base;
}