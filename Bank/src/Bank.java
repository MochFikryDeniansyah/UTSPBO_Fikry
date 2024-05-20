import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Akun> akunList;

    public Bank() {
        akunList = new ArrayList<>();
    }

    public void tambahAkun(Akun akun) {
        akunList.add(akun);
        System.out.println("Akun ditambahkan: " + akun.getNomorAkun());
    }

    public Akun cariAkun(String nomorAkun) {
        for (Akun akun : akunList) {
            if (akun.getNomorAkun().equals(nomorAkun)) {
                return akun;
            }
        }
        return null;
    }

    public void tampilkanSemuaAkun() {
        for (Akun akun : akunList) {
            System.out.println("Nomor Akun: " + akun.getNomorAkun() +
                    ", Pemilik Akun: " + akun.getNamaPemilikAkun() +
                    ", Saldo: " + akun.getSaldo() +
                    ", Bank: " + akun.getNamaBank());
        }
    }

    public void transfer(String dariNomorAkun, String keNomorAkun, double jumlah, double biaya) {
        Akun dariAkun = cariAkun(dariNomorAkun);
        Akun keAkun = cariAkun(keNomorAkun);

        if (dariAkun != null && keAkun != null) {
            dariAkun.transfer(keAkun, jumlah, biaya);
        } else {
            System.out.println("Salah satu atau kedua akun tidak ditemukan.");
        }
    }

    public void rekapTransaksiPerBulan(String nomorAkun, YearMonth bulan) {
        Akun akun = cariAkun(nomorAkun);
        if (akun != null) {
            System.out.println("Riwayat transaksi untuk akun " + nomorAkun + " pada bulan " + bulan + ":");
            for (Transaksi transaksi : akun.getRiwayatTransaksi()) {
                if (YearMonth.from(transaksi.getTanggal()).equals(bulan)) {
                    System.out.println(transaksi);
                }
            }
        } else {
            System.out.println("Akun tidak ditemukan.");
        }
    }
}