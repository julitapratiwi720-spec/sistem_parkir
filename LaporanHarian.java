import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LaporanHarian {
    private static final DateTimeFormatter tanggalFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final String FILE_PREFIX = "laporan_";

    public void tampilkanLaporan() {
        String tanggal = LocalDate.now().format(tanggalFormat);
        String fileName = FILE_PREFIX + tanggal + ".txt";

        System.out.println("\n=== Laporan Harian Parkir Kendaraan ===");
        System.out.println("Tanggal : " + tanggal);
        System.out.println("\nDaftar Kendaraan Keluar Hari Ini:");

        List<String> data = bacaDariFile(fileName);

        if (data.isEmpty()) {
            System.out.println("Belum ada kendaraan keluar hari ini.");
        } else {
            int i = 1;
            for (String baris : data) {
                System.out.println(i + ". " + baris);
                i++;
            }
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Total Kendaraan Masuk  : " + DaftarKendaraan.totalMasuk);
        System.out.println("Total Kendaraan Keluar : " + DaftarKendaraan.totalKeluar);
        System.out.println("Total Pendapatan Hari Ini : Rp " + DaftarKendaraan.totalPendapatan);
        System.out.println("----------------------------------------\n");
    }

    private List<String> bacaDariFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
        }
        return data;
    }

    public static void simpanKeFile(String isi) {
        String tanggal = LocalDate.now().format(tanggalFormat);
        String fileName = FILE_PREFIX + tanggal + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(isi);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Gagal menyimpan laporan ke file " + fileName);
        }
    }
}
