package modul3;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tugaspraktikum {
    static boolean isRunning = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    static String[] produk = { "Jaguar", "Lamborgini", "Honda", "Audi", "Suzuki", "Mazda", "Daihatsu", "Ford",
            "Hyundai", "Mitsubishi" };
    static long[] harga = { 1_340_000_000, 34_500_000_000L, 350_000_000, 2_000_000_000, 245_000_000, 500_000_000,
            169_000_000, 789_000_000,
            122_900_000, 278_100_000 };

    private static String numberToRupiah(Long n) {
        Locale locale = new Locale("id", "ID");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        DecimalFormat df = (DecimalFormat) nf;
        DecimalFormatSymbols dfs = new DecimalFormat().getDecimalFormatSymbols();
        dfs.setCurrency(df.getCurrency());
        dfs.setCurrencySymbol("Rp");
        dfs.setMonetaryDecimalSeparator(',');
        dfs.setMonetaryGroupingSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        return df.format(n);
    }

    static void cariProduk(String nama) {
        int i;
        boolean ada = false;
        for (i = 0; i < produk.length; i++) {
            if (produk[i].equals(nama)) {
                ada = true;
                break;
            }
        }
        if (ada) {
            System.out.println("Produk Ditemukan!");
            System.out.println("Produk : " + produk[i]);
            System.out.println("Harga  : " + numberToRupiah(harga[i]));
            System.out.println("Indeks : " + i);
        } else {
            System.out.println("Produk " + produk[i] + " Tidak Ditemukan!");
        }
    }

    static void mengurutkanMobil() {
        System.out.println("Produk Termurah Hingga Termahal");
        int n = harga.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (harga[j] > harga[j + 1]) {
                    Long tmp_harga = harga[j];
                    harga[j] = harga[j + 1];
                    harga[j + 1] = tmp_harga;
                    String tmp_produk = produk[j];
                    produk[j] = produk[j + 1];
                    produk[j + 1] = tmp_produk;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + produk[i] + " Seharga " + numberToRupiah(harga[i]));
        }
    }

    static void menunjukMobil(Integer i) {
        System.out.println("Harga Produk Termurah Nomor Ke-" + i);

        System.out.println("Produk Mobil " + produk[i - 1] + " Seharga " + numberToRupiah(harga[i - 1]));
    }
    static void Menu() throws IOException {
        System.out.println("========= MENU ========");
        System.out.println("[1] Tampilkan Audi");
        System.out.println("[2] Harga termurah hingga termahal");
        System.out.println("[3] Harga ke-2  produk termurah");
        System.out.print("PILIH MENU : ");
        int selectedMenu = Integer.valueOf(input.readLine());
        switch (selectedMenu) {
            case 1:
            cariProduk("Audi");
            System.out.println("");
                break;
            case 2:
            mengurutkanMobil();
            System.out.println("");
                break;
            case 3:
            menunjukMobil(2);
            System.out.println("");
                break;
            default:
                System.out.println("Maaf menu tidak tersedia!");
        }
    }

    public static void main(String[] args) throws IOException {
        do {
            Menu();
        } while (isRunning);
    }
}