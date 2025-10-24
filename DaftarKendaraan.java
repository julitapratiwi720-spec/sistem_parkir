import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DaftarKendaraan {
    static ArrayList<Kendaraan> dataKendaraan = new ArrayList<>();
    static ArrayList<String> laporanKeluar = new ArrayList<>();
    static int totalMasuk = 0;
    static int totalKeluar = 0;
    static long totalPendapatan = 0;

    public void tampilkanDaftar() {
        System.out.println("\n=== Daftar Kendaraan yang Sedang Parkir ===");
        if (dataKendaraan.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang sedang parkir.");
        } else {
            int i = 1;
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
            for (Kendaraan k : dataKendaraan) {
                System.out.println(i + ". " + k.getPlat() + " - " + k.getJenis() +
                        " - Masuk: " + k.getMasuk().format(fmt));
                i++;
            }
            System.out.println("------------------------------------------");
            System.out.println("Total kendaraan saat ini: " + dataKendaraan.size());
        }
        System.out.println();
    }
}
