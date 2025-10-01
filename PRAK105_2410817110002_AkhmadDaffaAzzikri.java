package prak101;

import java.util.Scanner;
import java.util.Locale;

public class PRAK105_2410817110002_AkhmadDaffaAzzikri {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

        final double PI = 3.14;

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        double jariJari = input.nextDouble();

        System.out.print("Masukkan tinggi: ");
        double tinggi = input.nextDouble();

        double volume = PI * jariJari * jariJari * tinggi;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f cm3\n", jariJari, tinggi, volume);

        input.close();
    }
}