import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ParkirMasuk {
    public void tampilkanForm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========================================");
        System.out.println("        Registrasi Kendaraan Masuk");
        System.out.println("========================================");
        System.out.print("Masukkan Nomor Plat     : ");
        String plat = sc.nextLine();
        System.out.print("Masukkan Jenis Kendaraan: ");
        String jenis = sc.nextLine();
        LocalTime waktuMasuk = LocalTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("\nWaktu Masuk Otomatis   : " + waktuMasuk.format(fmt));
        System.out.println("Data kendaraan berhasil disimpan!\n");
        DaftarKendaraan.dataKendaraan.add(new Kendaraan(plat, jenis, waktuMasuk));
        DaftarKendaraan.totalMasuk++;
    }
}
