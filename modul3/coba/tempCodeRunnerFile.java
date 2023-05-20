package modul3.coba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tempCodeRunnerFile {
    static boolean isRunning = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    static void termurah() {
        int A[] = new int[10];
        A[0] = 1340000;
        A[1] = 34500000;
        A[2] = 350000;
        A[3] = 2000000;
        A[4] = 245000;
        A[5] = 500000;
        A[6] = 169000;
        A[7] = 789000;
        A[8] = 122900;
        A[9] = 278100;
        int i, j, N = 10, temp;
        System.out.println("berikut tampilan 3 harga termurah ");
        System.out.println("================================================");
        for (i = 0; i < N; i++) {
            for (j = N - 1; j > i; j--) {
                if (A[j] < A[j - 1]) {
                    temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }
        for (j = 2; j < N; j--) {
            if (j < N) {
                System.out.println("Rp." + A[j] + "000");
            }

        }
        System.out.println("-------------------------------------");
    }

    static void semua() {
        String[][] nama = { { "Jaguar", "1.340.000.000" }, { "Lamborgini", "34.500.000.000" },
                { "Honda", "350.000.000" }, { "Audi", "2.000.000.000" }, { "Suzuki", "245.000.000" },
                { "Mazda", "500.000.000" }, { "Daihatsu", "169.000.000" }, { "Ford", "789.000.000" },
                { "Hyundai", "122.900.000" }, { "Mitsubishi", "278.100.000" } };

        for (int x = 0; x < nama.length; x++) {
            System.out.println("nama  : " + nama[x][0]);
            System.out.println("harga : Rp." + nama[x][1]);
            System.out.println("-------------------------------");
        }
    }

    static void cari() {
        String[] produk = {
                "Jaguar", "Lamborgini", "Honda", "Audi", "Suzuki", "Mazda", "Daihatsu", "Ford", "Hyundai",
                "Mitsubishi" };
        String cari = "Audi";
        int i;
        for (i = 0; i < produk.length; i++) {
            if (produk[i].equalsIgnoreCase(cari)) {
                System.out.println("Mobil " + cari + " Terdapat pada index  : " + i);
            }
        }
    }

    static void urut() {
        int A[] = new int[10];
        A[0] = 1340000;
        A[1] = 34500000;
        A[2] = 350000;
        A[3] = 2000000;
        A[4] = 245000;
        A[5] = 500000;
        A[6] = 169000;
        A[7] = 789000;
        A[8] = 122900;
        A[9] = 278100;
        int i, j, N = 10, temp;
        System.out.println("berikut tampilan harga termurah hinggga termahal");
        System.out.println("================================================");
        for (i = 0; i < N; i++) {
            for (j = N - 1; j > i; j--) {
                if (A[j] < A[j - 1]) {
                    temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }
        for (j = 0; j < N; j++) {
            System.out.println("Rp." + A[j] + "000");
        }
        System.out.println("-------------------------------------");
    }

    static void Menu() throws IOException {
        System.out.println("========= MENU ========");
        System.out.println("[1] Tampilkan Audi");
        System.out.println("[2] Harga termurah hingga termahal");
        System.out.println("[3] Tampilkan Produk sesuai nim");
        System.out.println("[4] Harga 3 produk termurah");
        System.out.println("[5] Tampilkan semua harga");
        System.out.print(" PILIH MENU ");
        int selectedMenu = Integer.valueOf(input.readLine());
        switch (selectedMenu) {
            case 1:
                cari();
                break;
            case 2:
                urut();
                break;
            case 3:
                nim();
                break;
            case 4:
                termurah();
                break;
            case 5:
                semua();
                break;
            default:
                System.out.println("Maaf menu tidak tersedia!");
        }
    }

    static void nim() {
        String[] nama = { "Jaguar", "Lamborgini", "Honda", "Audi", "Suzuki", "Mazda", "Daihatsu", "Ford", "Hyundai",
                "Mitsubishi" };
        String[] harga = { "1.340.000.000", "34.500.000.000", "350.000.000", "2.000.000.000", "245.000.000",
                "500.000.000", "169.000.000", "789.000.000", "122.900.000", "278.100.000" };
        System.out.println("nama  : " + nama[2]);
        System.out.println("harga : Rp." + harga[2]);
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) throws IOException {
        do {
            Menu();
        } while (isRunning);
    }
}
