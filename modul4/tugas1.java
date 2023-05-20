package modul4;

import java.util.Arrays;

public class tugas1 {
    public void prim(int G[][], int V) {
        int INF = 9999999;
        int no_edge;
        boolean[] selected = new boolean[V];
        Arrays.fill(selected, false);
        no_edge = 0;
        selected[0] = true;
        System.out.println("edge : weight");
        while (no_edge < V - 1) {
            int min = INF;
            int x = 0;
            int y = 0;
            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && G[i][j] != 0) {
                          if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " : " + G[x][y]);
            selected[y] = true;
            no_edge++;
        }
    }

    public static void main(String[] args) {
        tugas1 g = new tugas1();
        int V = 7;
        int[][] G = { { 0, 9, 12, 0, 11, 0, 15 }, { 9, 0, 4, 2, 3, 8, 0 },
                { 12, 4, 0, 0, 5, 10 }, { 0, 2, 0, 0, 8, 2 },
                { 11, 3, 5, 2, 0, 6, 14 }, { 0, 8, 0, 7, 6, 0, 0 },
                { 15, 0, 10, 0, 14, 0, 0 } };
        g.prim(G, V);
         {
    }
}}


