import java.time.LocalDateTime;

public class Transaksi {
    private String tipe;
    private double jumlah;
    private LocalDateTime tanggal;

    public Transaksi(String tipe, double jumlah) {
        this.tipe = tipe;
        this.jumlah = jumlah;
        this.tanggal = LocalDateTime.now();
    }

    public String getTipe() {
        return tipe;
    }

    public double getJumlah() {
        return jumlah;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    @Override
    public String toString() {
        return tanggal + " - " + tipe + ": " + jumlah;
    }
}