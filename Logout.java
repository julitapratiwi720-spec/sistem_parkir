import java.util.Scanner;

public class Logout {
    public void keluar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nApakah Anda yakin ingin logout? (y/n): ");
        String jwb = sc.nextLine();
        if (jwb.equalsIgnoreCase("y")) {
            System.out.println("Logout berhasil. Terima kasih telah menggunakan Sistem Parkir Kendaraan.");
            System.exit(0);
        }
    }
}
