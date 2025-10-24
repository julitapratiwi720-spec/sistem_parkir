import java.util.Scanner;

public class LoginAplikasiParkir {
    public void tampilkanLogin() {
        try (Scanner sc = new Scanner(System.in)) {
            String user = "admin";
            String pass = "123";
            boolean berhasil = false;
            System.out.println("========================================");
            System.out.println("   Login Aplikasi Sistem Parkir Kendaraan");
            System.out.println("========================================");
            while (!berhasil) {
                System.out.print("Username : ");
                String u = sc.nextLine();
                System.out.print("Password : ");
                String p = sc.nextLine();
                System.out.println("----------------------------------------");
                if (u.equals(user) && p.equals(pass)) {
                    System.out.println("Login berhasil!");
                    System.out.println("Selamat datang, Petugas Utama.");
                    berhasil = true;
                    MenuUtamaParkir menu = new MenuUtamaParkir();
                    menu.tampilkanMenu();
                } else {
                    System.out.println("Username atau password salah.");
                    System.out.println("Coba lagi.");
                    System.out.println("----------------------------------------");
                }
            }
        }
    }
}
