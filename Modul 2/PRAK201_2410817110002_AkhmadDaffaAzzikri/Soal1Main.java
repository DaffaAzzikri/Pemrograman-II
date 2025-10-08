package praktikum2.soal1;

public class Soal1Main {
    public static void main(String[] args) {
        Buah apel = new Buah("Apel", 0.4, 7000, 40.0);
        Buah mangga = new Buah("mangga", 0.2, 3500, 15.0);
        Buah alpukat = new Buah("alpukat", 0.25, 10000, 12.0);

        apel.info();
        System.out.println();
        mangga.info();
        System.out.println();
        alpukat.info();
    }
}
