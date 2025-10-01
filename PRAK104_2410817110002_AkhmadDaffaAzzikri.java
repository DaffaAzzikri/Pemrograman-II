package prak101;
import java.util.Scanner;

public class PRAK104_2410817110002_AkhmadDaffaAzzikri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tangan Abu: ");
        String[] tanganAbu = {scanner.next(), scanner.next(), scanner.next()};

        System.out.print("Tangan Bagas: ");
        String[] tanganBagas = {scanner.next(), scanner.next(), scanner.next()};
        
        scanner.close();

        int skorAbu = 0;
        int skorBagas = 0;

        for (int i = 0; i < 3; i++) {
            String pilihanAbu = tanganAbu[i];
            String pilihanBagas = tanganBagas[i];

            if ((pilihanAbu.equals("B") && pilihanBagas.equals("G")) ||
                (pilihanAbu.equals("G") && pilihanBagas.equals("K")) ||
                (pilihanAbu.equals("K") && pilihanBagas.equals("B"))) {
                skorAbu++;
            } else if (!pilihanAbu.equals(pilihanBagas)) {
                skorBagas++;
            }
        }

        if (skorAbu > skorBagas) {
            System.out.println("Abu");
        } else if (skorBagas > skorAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }
    }
}