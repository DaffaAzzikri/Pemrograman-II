package prak101;

import java.util.Scanner;
import java.util.Locale;
public class PRAK101_2410817110002_AkhmadDaffaAzzikri {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		scan.useLocale(Locale.US);
		
		System.out.print("Masukkan Nama Lengkap: ");
	    String nama = scan.nextLine();
	    
	    System.out.print("Masukkan Tempat Lahir: ");
	    String tempatLahir= scan.nextLine();
	
	    System.out.print("Masukkan Tanggal Lahir: ");
	    int tanggal = scan.nextInt();
	    
	    if (tanggal <= 0) {
	    	System.out.println("Tanggal yang dimasukkan tidak valid.");
	    	scan.close();
	    	return; 
	    }
	    
	    System.out.print("Masukkan Bulan Lahir: ");
	    int bulan = scan.nextInt();
	    
	    if (bulan < 1 || bulan > 12) {
	    	System.out.println("Bulan yang Anda masukkan tidak valid.");
	    	scan.close();
	    	return; 
	    }
	    System.out.print("Masukkan Tahun Lahir: ");
	    int tahun = scan.nextInt();
	    
	    System.out.print("Masukkan Tinggi Badan: ");
	    int tinggiBadan = scan.nextInt();
	    
	    if (tinggiBadan <= 0) {
	    	System.out.println("Tinggi badan yang dimasukkan tidak valid.");
	    	scan.close();
	    	return; 
	    }
	    
	    System.out.print("Masukkan Berat Badan: ");
	    double beratBadan = scan.nextDouble();
	    
	    if (beratBadan <= 0) {
	    	System.out.println("Berat badan yang dimasukkan tidak valid.");
	    	scan.close();
	    	return; 
	    }
	    String namaBulan = switch (bulan) {
	    case 1 -> "Januari";
	    case 2 -> "Februari";
	    case 3 -> "Maret";
	    case 4 -> "April";
	    case 5 -> "Mei";
	    case 6 -> "Juni";
	    case 7 -> "Juli"; 
	    case 8 -> "Agustus";
	    case 9 -> "September";
	    case 10 -> "Oktober";
	    case 11 -> "November";
	    case 12 -> "Desember";
	    default -> "Bukan Bulan yang valid!";
	    };
	    
	    
	    System.out.print("Nama Lengkap " + nama + ", "+ "Lahir di " + tempatLahir + " " + "pada Tanggal " + tanggal + " " + namaBulan +  " " + tahun + " " + "Tinggi Badan " + tinggiBadan + " dan Berat Badan " + beratBadan + " kilogram");
	
	    scan.close();;
	}
}