package modul3.coba;
import java.util.Arrays;

public class sorting {
    static int[] isi = { 13, 11, 2, 15, 12, 1, 4, 3, 10, 9, 5, 14, 6, 7, 8 };

    static void sort() {
        Arrays.sort(isi);
        System.out.print(" Data setelah di sorting : "
                + Arrays.toString(isi).replace("[", "").replace("]", "").replace(",", ""));
        System.out.print("\n<<<-------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------------->>>");
        System.out.print(" Data sebelum di sorting : ");
        for (int i = 0; i < isi.length; i++) {
            System.out.print(isi[i] + " ");
        }
        System.out.println(" ");
        sort();

    }
}
