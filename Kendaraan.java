import java.time.LocalTime;

public class Kendaraan {
    private final String plat;
    private final String jenis;
    private final LocalTime masuk;

    public Kendaraan(String plat, String jenis, LocalTime masuk) {
        this.plat = plat;
        this.jenis = jenis;
        this.masuk = masuk;
    }

    public String getPlat() {
        return plat;
    }

    public String getJenis() {
        return jenis;
    }

    public LocalTime getMasuk() {
        return masuk;
    }
}
