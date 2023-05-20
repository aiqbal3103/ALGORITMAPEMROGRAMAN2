package modul3.coba;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.Arrays;

public class array {

    // Deklarasi kelas
    public class MengurutkanElemen {

        // Metoda main
        public static void main(String[] args) {

            int[] nilaiInteger = { (int) 30.000, 2, 6, (int) 40.000, 8, 7, 9, 1, 5, 10 };
            char[] nilaiKarakter = { 'd', 'c', 'g', 'f', 'i', 'a', 'b', 'h', 'e' };

            String tampilan;
            JTextArea areaTampilan;

            // Menampilkan elemen larik integer
            tampilan = "Menampilkan elemen larik integer :\n";
            for (int x = 0; x < nilaiInteger.length; x++)
                tampilan += nilaiInteger[x] + "   ";

            Arrays.sort(nilaiInteger);

            // Menampilkan elemen larik integer setelah diurutkan
            tampilan += "\nMenampilkan elemen larik integer setelah diurutkan :\n";
            for (int x = 0; x < nilaiInteger.length; x++)
                tampilan += nilaiInteger[x] + "   ";

            // Menampilkan elemen larik karakter
            tampilan += "\n\nMenampilkan elemen larik karakter :\n";
            for (int x = 0; x < nilaiKarakter.length; x++)
                tampilan += nilaiKarakter[x] + "   ";

            Arrays.sort(nilaiKarakter);

            // Menampilkan elemen larik karakter setelah diurutkan
            tampilan += "\nMenampilkan elemen larik karakter setelah diurutkan :\n";
            for (int x = 0; x < nilaiKarakter.length; x++)
                tampilan += nilaiKarakter[x] + "   ";

            areaTampilan = new JTextArea();
            areaTampilan.setText(tampilan);
            JOptionPane.showMessageDialog(null, areaTampilan, "Mengurutkan Elemen Larik",
                    JOptionPane.INFORMATION_MESSAGE);

            // Mengakhiri aplikasi
            System.exit(0);
        }
    }
}
