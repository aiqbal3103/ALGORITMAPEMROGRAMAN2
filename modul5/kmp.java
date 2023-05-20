package modul5;
import java.util.Scanner;
public class kmp {
    void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        // buat variabel lps[] untuk menangani
        // nilai awalan dan akhiran terpanjang untuk pattern/pola
        int lps[] = new int[M];
        int j = 0;
        // pra pemrosesan pattern (kalkulasi array lps[])
        computeLPSArray(pat, M, lps);
        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println(" Text ditemukan pada "
                        + " index ke " + (i - j));
                j = lps[j - 1];
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            } } }
    void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        // Looping untuk kalkulasi lps[i] = 1 sampai M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                } }
        }
    } }

    Fungsi Main
    public static void main(String args[]) {
        String x, y;
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.print(" Masukkkan Text: ");
        x = input.nextLine();
        System.out.println("----------------------------------");
        System.out.print(" Masukkkan Text yang di cari: ");
        y = input.nextLine();
        System.out.println("----------------------------------");
        String txt = x;
        String pat = y;
        new kmp().KMPSearch(pat, txt);
        input.close();
    }
