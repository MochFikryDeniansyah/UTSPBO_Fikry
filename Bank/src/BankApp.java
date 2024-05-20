import java.time.YearMonth;
import java.util.Scanner;

public class BankApp {
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Tambah akun");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Transfer");
            System.out.println("5. Tampilkan Semua Akun");
            System.out.println("6. Rekap Transaksi per Bulan");
            System.out.println("7. Keluar");
            System.out.print("Masukkan pilihan : ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahAkun(scanner);
                    break;
                case 2:
                    setor(scanner);
                    break;
                case 3:
                    tarik(scanner);
                    break;
                case 4:
                    transfer(scanner);
                    break;
                case 5:
                    bank.tampilkanSemuaAkun();
                    break;
                case 6:
                    rekapTransaksiPerBulan(scanner);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }

    private static void tambahAkun(Scanner scanner) {
        System.out.print("Masukkan nomor akun: ");
        String nomorAkun = scanner.next();
        System.out.print("Masukkan nama pemilik akun: ");
        String namaPemilikAkun = scanner.next();
        System.out.print("Masukkan saldo awal: ");
        double saldoAwal = scanner.nextDouble();
        System.out.print("Masukkan nama bank: ");
        String namaBank = scanner.next();

        Akun akun = new Akun(nomorAkun, namaPemilikAkun, saldoAwal, namaBank);
        bank.tambahAkun(akun);
    }

    private static void setor(Scanner scanner) {
        System.out.print("Masukkan nomor akun: ");
        String nomorAkun = scanner.next();
        Akun akun = bank.cariAkun(nomorAkun);

        if (akun != null) {
            System.out.print("Masukkan jumlah setoran: ");
            double jumlah = scanner.nextDouble();
            akun.setor(jumlah);
        } else {
            System.out.println("Akun tidak ditemukan.");
        }
    }

    private static void tarik(Scanner scanner) {
        System.out.print("Masukkan nomor akun: ");
        String nomorAkun = scanner.next();
        Akun akun = bank.cariAkun(nomorAkun);

        if (akun != null) {
            System.out.print("Masukkan jumlah penarikan: ");
            double jumlah = scanner.nextDouble();
            akun.tarik(jumlah);
        } else {
            System.out.println("Akun tidak ditemukan.");
        }
    }

    private static void transfer(Scanner scanner) {
        System.out.print("Masukkan nomor akun pengirim: ");
        String dariNomorAkun = scanner.next();
        System.out.print("Masukkan nomor akun penerima: ");
        String keNomorAkun = scanner.next();
        System.out.print("Masukkan jumlah transfer: ");
        double jumlah = scanner.nextDouble();
        System.out.print("Masukkan biaya transfer: ");
        double biaya = scanner.nextDouble();

        bank.transfer(dariNomorAkun, keNomorAkun, jumlah, biaya);
    }

    private static void rekapTransaksiPerBulan(Scanner scanner) {
        System.out.print("Masukkan nomor akun: ");
        String nomorAkun = scanner.next();
    }
}