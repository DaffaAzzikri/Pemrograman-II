package praktikum2.soal1;

class Buah {
	private String nama;
	private double berat;
	private double harga;
	private double jumlahBeli;


	public Buah(String nama, double berat, double harga, double jumlahBeli) {
	
		this.nama = nama;
		this.berat = berat;
		this.harga = harga;
		this.jumlahBeli = jumlahBeli;
	}

	public double hitungHargaSebelumDiskon() {
		double jumlahUnit = jumlahBeli / berat;
		return jumlahUnit * harga;
}

	public double hitungDiskon() {
		double diskon = Math.floor(jumlahBeli / 4.0) * 4.0;
		return 0.02 * diskon * harga;
}

	public double hitungHargaSetelahDiskon() {
		return hitungHargaSebelumDiskon() - hitungDiskon();
}

	public void info() {
	    System.out.println("Nama Buah: " + nama);
	    System.out.printf("Berat: %.1f%n", berat);
	    System.out.printf("Harga: %.1f%n", harga);
	    System.out.printf("Jumlah Beli: %.1fkg%n", jumlahBeli);
	    System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", hitungHargaSebelumDiskon());
	    System.out.printf("Total Diskon: Rp%.2f%n", hitungDiskon());
	    System.out.printf("Harga Setelah Diskon: Rp%.2f%n", hitungHargaSetelahDiskon());
}
}