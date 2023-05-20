package modul4;

import java.util.Scanner;

public class StringMatching {
    
    public final static int d = 256;
    
    static final int NO_OF_CHARS = 256;
    
    static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void Naive(String txt, String pattern) {
		final int kalimat   = pattern.length();
		final int cari      = txt.length();
		int j, i;
		for (i = 0; i <= cari - kalimat; i++) {
			for (j = 0; j < kalimat; j++) {
				if (txt.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == kalimat) {
				System.out.println("Pola Ditemukan Pada Index Ke - " + i);
			}
		}
	}

    static void rabinKrap(String txt, String pattern, int q) {
        int M = pattern.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value pattern
        int t = 0; // hash value text
        int h = 1; // nilai awal h

        // menghitung nilai awal h dengan menggunakan metode eksponenial
        for(i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // menghitung hash value pattern dan text
        for (i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // melakukan pencarian pola pada text
        for (i = 0; i <= N - M; i++) {
            // jika hash value pattern dan text sama, maka dilakukan pengecekan karakter per karakter
	        if (p == t) {
	            for (j = 0; j < M; j++) {
	                if (txt.charAt(i + j) != pattern.charAt(j)) {
	                    break;
	                }
	            }
	            // jika semua karakter sama, maka pola ditemukan
	            if (j == M) {
	                System.out.println("Pola Ditemukan Pada Index Ke - " + i);
	            }
	        }
	        // menghitung hash value text baru dengan metode rolling hash
	        if ( i < N - M) {
	            t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
	            // jika hash value negatif, maka diubah menjadi positif
	            if (t < 0) {
	                t = (t + q);
	            }
	        }
	    }
	}

	
	static void computeLPSArray(String pattern, int M, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0;
		while(i < M) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}else {
				if(len != 0) {
					len = lps[len -1];
				}else {
					lps [i] = len;
					i++;
				}
			}
		}
	}
	
	static void KMP(String txt, String pattern) {
	    int M = pattern.length();
	    int N = txt.length();
	    int lps[] = new int [M];
	    int j = 0;
	    computeLPSArray(pattern, M, lps);
	    int i = 0;
	    while(i < N) {
	        // jika karakter pada pattern dan text sama, maka dilakukan pengecekan karakter berikutnya
	        if(pattern.charAt(j) == txt.charAt(i)) {
	            j++;
	            i++;
	        }
	        // jika semua karakter pada pattern sama dengan text, maka pola ditemukan
	        if(j == M) {
	            System.out.println("Pola Ditemukan Pada Index Ke - " +(i - j));
	            j = lps[j - 1]; // mengembalikan nilai j ke nilai lps sebelumnya
	        } else if(i < N && pattern.charAt(j) != txt.charAt(i)) {
	            // jika karakter tidak sama, maka dilakukan penyesuaian nilai j dan i
	            if (j != 0) {
	                j = lps[j - 1]; // mengembalikan nilai j ke nilai lps sebelumnya
	            } else {
	                i = i + 1; // tidak ada karakter pada pattern yang sama dengan karakter pada text, maka i akan di-increment
	            }
	        }
	    }
	}
	
	static int FSA(String pattern, int M, int state, char x) {
	    if (state < M && x == pattern.charAt(state))
	        return state + 1;

	    int ns, i;

	    for (ns = state; ns > 0; ns--) {
	        if (pattern.charAt(ns - 1) == x) {
	            for (i = 0; i < ns - 1; i++)
	                if (pattern.charAt(i) != pattern.charAt(state - ns + 1 + i))
	                    break;
	            if (i == ns - 1)
	                return ns;
	        }
	    }

	    return 0;
	}

	static void computeTF(String pattern, int M, int[][] TF) {
	    int state;
	    char x;
	    for (state = 0; state <= M; ++state)
	        for (x = 0; x < NO_OF_CHARS; ++x)
	            TF[state][x] = FSA(pattern, M, state, (char)x);
	}

	static void search(String pattern, String txt) {
	    int M = pattern.length();
	    int N = txt.length();

	    int[][] TF = new int[M + 1][NO_OF_CHARS];

	    computeTF(pattern, M, TF);

	    int i, state = 0;
	    for (i = 0; i < N; i++) {
	        state = TF[state][txt.charAt(i)];
	        if (state == M)
	            System.out.println("Pola Ditemukan Pada Index Ke - " + (i - M + 1));
	    }
	}
	
	static void Exit() {
		System.out.println("Terimakasih!");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int q = 300;
		int pilih = 0;
		while (pilih != 4) {
			//StringMatching.clear();
			System.out.println("=========================================");
			System.out.println("---------- String Matching Java ---------");
			System.out.println("=========================================");
			System.out.print("Masukkan Kalimat : "); String txt        = input.nextLine();
			System.out.println("");
			System.out.print("Kata Kunci       : "); String pattern    = input.nextLine();
			char [] patternF = pattern.toCharArray();
			char [] txtF     = txt.toCharArray();
			System.out.println("");
			System.out.println("=========================================");
			System.out.println("--------- - Metode Pencarian ------------");
			System.out.println("=========================================");
			System.out.println("1. Naiven\n2. Rabin Karp\n3. Finite State Automata\n4. Knuth Morris Pratt\n5. Exit");
			System.out.print("Pilih Metode : "); 
			pilih = input.nextInt();
			switch (pilih) {
			case 1:
				Naive(txt, pattern);
				break;
			case 2:
				rabinKrap(txt, pattern, q);
				break;
			case 3:
				KMP(txt, pattern);
				break;
			case 4:
				search(pattern, txt);
				break;
			case 5:
				Exit();
				break;
			default :
				System.out.print("Input Salah Silahkan Ulangi!");
				break;
			}
			System.out.println("Tekan Enter Untuk Lanjut...");
		}
		// input.close();
	}
}

