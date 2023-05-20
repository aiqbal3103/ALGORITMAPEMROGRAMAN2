package modul5;

import java.util.Scanner;
public class tugas {
    static String x;
    static String y;

// metode naive
    public static void naive() {
        String txt = x;
        String pat = y;
        search(txt, pat);
    }

    static void search(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        for (int s = 0; s <= n - m; s++) {
            int j;
            for (j = 0; j < m; j++)
                if (str.charAt(s + j) != pattern.charAt(j))
                    break;
            if (j == m)
                System.out.println("Text muncul pada indeks ke- " + s);
        }
    }

// metode rabinkarp
    public static void Rabinkarp() {
        String txt = x;
        String pattern = y;
        int q = 13;
        seach(pattern, txt, q);
    }
    public final static int d = 10;

    static void seach(String pattern, String txt, int q) {
        int m = pattern.length();
        int n = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == m)
                    System.out.println("Text ditemukan pada posisi: " + i);
            }
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                if (t < 0)
                    t = (t + q);
            }
        }
    }

// metode Finite State Automata
    public static void Infinite() {
        char[] pat = x.toCharArray();
        char[] txt = y.toCharArray();
        sea(txt, pat);
    }

    static int NO_OF_CHARS = 256;

    static int getNextState(char[] pat, int M, int state, int x) {
        if (state < M && x == pat[state])
            return state + 1;
        int ns, i;
        for (ns = state; ns > 0; ns--) {
            if (pat[ns - 1] == x) {
                for (i = 0; i < ns - 1; i++)
                    if (pat[i] != pat[state - ns + 1 + i])
                        break;
                if (i == ns - 1)
                    return ns;
            }
        }
        return 0;
    }
    
    static void computeTF(char[] pat, int M, int TF[][]) {
        int state, x;
        for (state = 0; state <= M; ++state)
            for (x = 0; x < NO_OF_CHARS; ++x)
                TF[state][x] = getNextState(pat, M, state, x);
    }

    static void sea(char[] pat, char[] txt) {
        int M = pat.length;
        int N = txt.length;
        int[][] TF = new int[M + 1][NO_OF_CHARS];
        computeTF(pat, M, TF);
        int i, state = 0;
        for (i = 0; i < N; i++) {
            state = TF[state][txt[i]];
            if (state == M)
                System.out.println("Text berada pada "
                        + "index " + (i - M + 1));
        }
    }

// metode Knuth Morris Pratt
    public static void kmp() {
        String txt = x;
        String pat = y;
        new kmp().KMPSearch(pat, txt);
    }

    static void Exit() {
		System.out.println("Terimakasih!");
		System.exit(0);
	}

    public static void main(String args[]) {
        int metode;
        int pilih = 0;
		while (pilih != 4) {
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("=========================================");
		System.out.println("---------- String Matching Java ---------");
		System.out.println("=========================================");
        System.out.print(" Masukkkan Kalimat: ");
        x = input.nextLine();
        System.out.println("----------------------------------");
        System.out.print(" Masukkkan Kata Kunci: ");
        y = input.nextLine();
		System.out.println("=========================================");
		System.out.println("--------- - Metode Pencarian ------------");
		System.out.println("=========================================");
		System.out.println("1. Naiven\n2. Rabin Karp\n3. Finite State Automata\n4. Knuth Morris Pratt\n5. Exit");
		System.out.print("Pilih Metode : ");
        metode = input.nextInt();
        System.out.println("----------------------------------");
        switch (metode) {
            case 1:
                naive();
                break;
            case 2:
                Rabinkarp();
                break;
            case 3:
                Infinite();
                break;
            case 4:
                kmp();
                break;
            case 5:
                Exit();
                break;
            default :
				System.out.print("Input Salah Silahkan Ulangi!");
				break;
			}
        }
    }
}