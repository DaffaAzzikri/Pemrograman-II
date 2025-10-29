package praktikum4.soal1;
import java.util.Scanner;

public class Main {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Nama Hewan Peliharaan: ");
	        String inputNama = scanner.nextLine();

	        System.out.print("Ras: ");
	        String inputRas = scanner.nextLine();

	        HewanPeliharaan hewan = new HewanPeliharaan(inputRas, inputNama);

	        hewan.display();
	        scanner.close();
	    }
	}