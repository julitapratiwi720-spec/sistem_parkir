import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ParkirKeluar {
    public void tampilkanForm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========================================");
        System.out.println("        Registrasi Kendaraan Keluar");
        System.out.println("========================================");
        System.out.print("Masukkan Nomor Plat : ");
        String plat = sc.nextLine();

        Kendaraan target = null;
        for (Kendaraan k : DaftarKendaraan.dataKendaraan) {
            if (k.getPlat().equalsIgnoreCase(plat)) {
                target = k;
                break;
            }
        }

        if (target == null) {
            System.out.println("Nomor plat tidak ditemukan!\n");
        } else {
            LocalTime keluar = LocalTime.now();
            Duration durasi = Duration.between(target.getMasuk(), keluar);
            long jam = durasi.toHours();
            long menit = durasi.toMinutes() % 60;
            if (jam == 0) jam = 1;
            int tarif = target.getJenis().equalsIgnoreCase("Mobil") ? 5000 : 3000;
            long total = jam * tarif;
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
            System.out.println("\nWaktu Keluar Otomatis : " + keluar.format(fmt));
            System.out.println("Durasi Parkir         : " + jam + " jam " + menit + " menit");
            System.out.println("Tarif Parkir          : Rp " + tarif + " / jam");
            System.out.println("Total Biaya           : Rp " + total);
            System.out.println("\nKendaraan berhasil keluar. Terima kasih!!\n");

            String data = target.getPlat() + " - " + target.getJenis() + " - "
                    + jam + " jam " + menit + " menit - Rp " + total;

            DaftarKendaraan.laporanKeluar.add(data);
            DaftarKendaraan.totalKeluar++;
            DaftarKendaraan.totalPendapatan += total;
            DaftarKendaraan.dataKendaraan.remove(target);
            LaporanHarian.simpanKeFile(data);
        }
    }
}
