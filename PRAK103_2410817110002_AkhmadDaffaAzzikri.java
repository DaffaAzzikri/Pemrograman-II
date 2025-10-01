package prak101;

import java.util.Scanner;

public class PRAK103_2410817110002_AkhmadDaffaAzzikri {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print(" ");
		int n = scan.nextInt();
		int bilanganAwal = scan.nextInt();
		
		int i = 0;
		
		do {
			if (bilanganAwal % 2 != 0) {
                System.out.print(bilanganAwal + " ");
                i++;
			}
			bilanganAwal++;
		} while (i < n);
		
		scan.close();
		
	}
}