import java.util.Scanner;

public class MenuUtamaParkir {
    public void tampilkanMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            int pilih = 0;
            ParkirMasuk masuk = new ParkirMasuk();
            ParkirKeluar keluar = new ParkirKeluar();
            DaftarKendaraan daftar = new DaftarKendaraan();
            LaporanHarian laporan = new LaporanHarian();
            Logout logout = new Logout();
            do {
                System.out.println("========================================");
                System.out.println("     Menu Utama Sistem Parkir Kendaraan");
                System.out.println("========================================");
                System.out.println("1. Registrasi Kendaraan Masuk");
                System.out.println("2. Registrasi Kendaraan Keluar");
                System.out.println("3. Lihat Daftar Kendaraan");
                System.out.println("4. Buat Laporan Harian");
                System.out.println("5. Logout");
                System.out.println("----------------------------------------");
                System.out.print("Pilih menu : ");
                if (sc.hasNextInt()) {
                    pilih = sc.nextInt();
                    sc.nextLine();
                } else {
                    sc.nextLine();
                    continue;
                }
                switch (pilih) {
                    case 1 -> masuk.tampilkanForm();
                    case 2 -> keluar.tampilkanForm();
                    case 3 -> daftar.tampilkanDaftar();
                    case 4 -> laporan.tampilkanLaporan();
                    case 5 -> logout.keluar();
                    default -> System.out.println("\nPilihan tidak valid.\n");
                }
            } while (pilih != 5);
        }
    }
}
