package modul4;

public class finiti {
    static int NO_OF_CHARS = 256;

    static int getNextState(char[] pat, int M, int state, int x) {
        // Jika karakter c sama dengan karakter berikutnya di dalam pattern maka
        // increment state
        if (state < M && x == pat[state])
            return state + 1;

        // ns adalah variabel yang menyimpan hasil state berikutnya (next state)
        int ns, i;
        // berikutnya ns berisi awalan terpanjang
        // yang juga merupakan akhiran dalam "pat [0..state-1] c"
        // Mulai dari kemungkinan nilai terbesar
        // dan berhenti ketika Anda menemukan awalan yang akhiran
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

    /* membangun tabel untuk merepresentasikikan fungsi automata dari suatu pola */
    static void computeTF(char[] pat, int M, int TF[][]) {
        int state, x;
        for (state = 0; state <= M; ++state)
            for (x = 0; x < NO_OF_CHARS; ++x)
                TF[state][x] = getNextState(pat, M, state, x);
    }

    /* Mencetak kemunculan pola dalam text */
    static void search(char[] pat, char[] txt) {
        int M = pat.length;
        int N = txt.length;

        int[][] TF = new int[M + 1][NO_OF_CHARS];

        computeTF(pat, M, TF);

        // process pencocokan teks ke pola.
        int i, state = 0;
        for (i = 0; i < N; i++) {
            state = TF[state][txt[i]];
            if (state == M)
                System.out.println("Text berada pada "
                        + "index " + (i - M + 1));
        }
    }

    // Fungsi Main
    public static void main(String[] args) {
        char[] pat = "Saya mau makan".toCharArray();
        char[] txt = "ma".toCharArray();
        search(txt, pat);
    }
}