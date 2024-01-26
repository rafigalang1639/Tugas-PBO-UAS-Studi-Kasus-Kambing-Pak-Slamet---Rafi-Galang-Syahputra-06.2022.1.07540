import java.util.ArrayList;
abstract class Hewan {
    private int berat;
    private int tinggi;
    private int panjang;

    public Hewan(int berat, int tinggi, int panjang) {
        this.berat = berat;
        this.tinggi = tinggi;
        this.panjang = panjang;
    }

    public abstract String getSuara();

    public String getInfo() {
        return "Berat: " + berat + " kg, Tinggi: " + tinggi + " cm, Panjang: " + panjang + " cm";
    }

    // Getter dan setter untuk berat, tinggi, dan panjang
    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getPanjang() {
        return panjang;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }
}

class Kambing extends Hewan {
    private int usia;
    private String nama; // nama/jenis

    public Kambing(String nama, int berat, int tinggi, int panjang, int usia) {
        super(berat, tinggi, panjang);
        this.usia = usia;
        this.nama = nama;
    }

    @Override
    public String getSuara() {
        return "Mbek mbek!";
    }

    public int getUsia() {
        return usia;
    }

    public String getNama() {
        return nama;
    }

    public void perkembanganBulanan() {
        usia++;
        setBerat(getBerat() + 1);  //tambahan 1 kg setiap bulan
        setTinggi(getTinggi() + 1);  // tambahan 1 cm setiap bulan
        setPanjang(getPanjang() + 2);  // tambahan 2 cm setiap bulan
    }
}

class PedagangKambing {
    private ArrayList<Kambing> daftarKambing;

    public PedagangKambing() {
        daftarKambing = new ArrayList<>();
    }

    public void beliKambing(String nama, int berat, int tinggi, int panjang) {
        Kambing kambingBaru = new Kambing(nama, berat, tinggi, panjang, 0);
        daftarKambing.add(kambingBaru);
    }

    public void tampilkanInformasiKambing() {
        System.out.println("Informasi Kambing:");
        for (Kambing kambing : daftarKambing) {
            System.out.println("Nama: " + kambing.getNama());
            System.out.println("Usia: " + kambing.getUsia() + " bulan");
            System.out.println(kambing.getInfo());
            System.out.println();
        }
    }

    public void perkembanganBulanan() {
        for (Kambing kambing : daftarKambing) {
            kambing.perkembanganBulanan();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PedagangKambing pakSlamet = new PedagangKambing();
        pakSlamet.beliKambing("Kambing Hitam", 30, 80, 100);
        pakSlamet.beliKambing("Kambing Putih", 25, 75, 90);

        pakSlamet.tampilkanInformasiKambing();
        System.out.println("-----------------------------------------------");

        for (int i = 1; i <= 12; i++) {
            System.out.println("\nPerkembangan Bulan ke-" + i + ":");
            pakSlamet.perkembanganBulanan();
            pakSlamet.tampilkanInformasiKambing();
            System.out.println("-----------------------------------------------");
        }
    }
}
