package prak101;
import java.util.Scanner;

public class PRAK102_2410817110002_AkhmadDaffaAzzikri {
	
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);

	        System.out.print(" ");
	        int angka = scan.nextInt();

	        int i = 0;
	        
	        while (i < 11) {
	            
	            if (angka % 5 == 0) {
	                
	                int hasil = (angka / 5) - 1;
	                System.out.print(hasil);
	            } else {
	                
	                System.out.print(angka);
	            }

	            if (i < 10) {
	                System.out.print(",");
	            }
	            
	            angka++;
	            i++;
	        }

	        scan.close();
	    }
	}

