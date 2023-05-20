package responsi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Responsi_Shortest_Path {

    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    // Mendefinisikan Class Edge Untuk menyimpan nilai / bobot dari titik awal (src) ke titik tujuan (dest)
    class Edge {
        int src, dest;
        double weight; // tipe data double berjutuan untuk menyimpan data pecahan 

        /*mendefinisikan nilai awal dari src (source) , dest (destination) , dan 
        bobot (weight) atau jarak antar simpul pada struktur data graph. */
        Edge() {
            src = dest = 0;
            weight = 0;
        }
    };
    
    // V = vertek (titik atau simpul yang digunakan untuk merepresentasikan suatu objek atau konsep dalam graph.)
    // E = edge (garis atau sisi yang menghubungkan dua vertex atau lebih dalam graph. )
    int V, E; 
            
    Edge edge[]; // mendeklarasikan  edge sebagai array yang berisi objek-objek dari kelas Edge

    // menginisialisasi array edge  dengan ukuran e. (untuk menampung objek dari class Edge)
    Responsi_Shortest_Path(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

   // method yang berfungsi untuk menemukan jalur terpendek dari sebuah vertex (simpul) pada graph 
    void Shortest_Path (Responsi_Shortest_Path graph, int src, int dest) {
        int V = graph.V, E = graph.E;
        double dist[] = new double[V];
        for (int i = 0; i < V; ++i)
            dist[i] = Double.POSITIVE_INFINITY;
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                double weight = graph.edge[j].weight;
                if (dist[u] != Double.POSITIVE_INFINITY && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }
        // pengulangan untuk perkondisi jika nilai / bobot dari vertek negatif
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            double weight = graph.edge[j].weight;
            if (dist[u] != Double.POSITIVE_INFINITY && dist[u] + weight < dist[v]) {
                System.out.println("NILAI PADA GRAPH NEGATIF!!!");
                return;
            }
        }
        //untuk menampilkan jumlah bobot dari jalur terpendek yang dipilih
        System.out.println(src + " Menuju " + dest + " dengan Bobot " + dist[dest]);

        // untuk menampilkan jalur yang dipilih 
        System.out.print("Jalur Terpendek: " + src + " ");
        int i = dest;
        while (i != src) {
            for (int j = 0; j < E; ++j) {
                if (edge[j].dest == i && dist[edge[j].src] + edge[j].weight == dist[i]) {
                    System.out.print("<-- " + edge[j].weight + " <-- " + edge[j].src + " ");
                    i = edge[j].src;
                    break;
                }
            }
        }
        System.out.println();

    }

//metod yang berfungsi untuk untuk mencetak array berisi jarak atau bobot (dist) dari titik awal (src) ke semua titik lainnya (dest) 
    void printArr(double dist[], int V, int src) { 
        int[] dest = new int[V];
        for (int s = 0; s < V; s++) {
            dest[s] = s;
        }
        for (int i = 0; i < V; ++i)
            for (int j = 0; j < V - i - 1; j++) {
                if (dist[j] > dist[j + 1]) {
                    double temp = dist[j]; 
                    dist[j] = dist[j + 1];
                    dist[j + 1] = temp;
    
                    int destemp = dest[j]; 
                    dest[j] = dest[j + 1];
                    dest[j + 1] = destemp;
                }
            }
    
        for (int i = 0; i < V; ++i)
            System.out.println(src + " Menuju " + dest[i] + " dengan Bobot " + dist[i]);
    }
    

    // mentod untuk menentukan asal dan tujuannya
    static void satu(Responsi_Shortest_Path graph, int src) throws IOException {
        System.out.println("===== Menu  =====");
        System.out.print("Masukan Asal : ");
        int masuk = Integer.valueOf(input.readLine());
        System.out.print("Masukan Tujuan : ");
        int tujuan = Integer.valueOf(input.readLine());
        graph.Shortest_Path(graph, masuk, tujuan);
    }

    public static void main(String[] args) throws IOException {
        int V = 18; // Jumlah Vertek pada graph
        int E = 22; // jumlah edge pada graph
        int masuk = 0;
        int selectedMenu;
        Responsi_Shortest_Path graph = new Responsi_Shortest_Path(V, E);

        graph.edge[0].src = 0; // JURUSAN TI
        graph.edge[0].dest = 1; // JALUR DEPAN 
        graph.edge[0].weight = 48.47; // BOBOT

        graph.edge[1].src = 0; // JURUSAN TI
        graph.edge[1].dest = 2; // JALUR BELAKANG
        graph.edge[1].weight = 94.84; // BOBOT

        graph.edge[2].src = 1; // JALUR DEPAN
        graph.edge[2].dest = 3; // HENDRIK TIMMANG KANAN
        graph.edge[2].weight = 0; // BOBOT

        graph.edge[3].src = 1; // JALUR DEPAN
        graph.edge[3].dest = 4; // HENDRIK TIMMANG KIRI
        graph.edge[3].weight = 0; //BOBOT

        graph.edge[4].src = 2; // JALUR BELAKANG
        graph.edge[4].dest = 5; // JALUR BELAKANG BELOK KIRI
        graph.edge[4].weight = 0;

        graph.edge[5].src = 3; // HENDRIK TIMMANG KANAN
        graph.edge[5].dest = 6; // GERBANG UPR
        graph.edge[5].weight = 266.75; // BOBOT

        graph.edge[6].src = 4; // HENDRIK TIMMANG KIRI
        graph.edge[6].dest = 7; // BUKIT KEMINTING
        graph.edge[6].weight = 498.90; // BOBOT

        graph.edge[7].src = 5;  // JALUR BELAKANG BELOK KIRI
        graph.edge[7].dest = 8; // BUKIT KEMINTING (JALUR BELAKANG)
        graph.edge[7].weight = 497.44; // BOBOT

        graph.edge[8].src = 6; // GERBANG UPR
        graph.edge[8].dest = 9; // YOS SUDARSO INDUK
        graph.edge[8].weight = 408.45; // BOBOT

        graph.edge[9].src = 7; // BUKIT KEMINTING (HENDRIK TIMMANG KIRI)
        graph.edge[9].dest = 10; // YOS SUDARSO INDUK 2
        graph.edge[9].weight = 295.32; // BOBOT

        graph.edge[10].src = 8; // BUKIT KEMINTING (JALUR BELAKANG)
        graph.edge[10].dest = 10; // YOS SUDARSO INDUK 2
        graph.edge[10].weight = 138.20; // BOBOT

        graph.edge[11].src = 9; // YOS SUDARSO INDUK
        graph.edge[11].dest = 11; // GALAXY RAYA
        graph.edge[11].weight = 743.36; // BOBOT

        graph.edge[12].src = 9; // YOS SUDARSO INDUK
        graph.edge[12].dest = 10; // YOS SUDARSO INDUK 2
        graph.edge[12].weight = 1020; // BOBOT

        graph.edge[13].src = 10; // YOS SUDARSO INDUK 2
        graph.edge[13].dest = 11; // GALAXY RAYA
        graph.edge[13].weight = 270.43; // BOBOT

        graph.edge[14].src = 10; // YOS SUDARSO INDUK 2
        graph.edge[14].dest = 12; // YOS SUDARSO VI
        graph.edge[14].weight = 555.44; // BOBOT

        graph.edge[15].src = 10; // YOS SUDARSO INDUK 2
        graph.edge[15].dest = 13; // G. OBOS XII
        graph.edge[15].weight = 1500; // BOBOT

        graph.edge[16].src = 11; // GALAXY RAYA
        graph.edge[16].dest = 14; // G. OBOS INDUK
        graph.edge[16].weight = 1050; // BOBOT

        graph.edge[17].src = 12; // YOS SUDARSO VI
        graph.edge[17].dest = 15; // G.OBOS VII
        graph.edge[17].weight = 1190; // BOBOT

        graph.edge[18].src = 13; // G. OBOS XII
        graph.edge[18].dest = 16; // G. OBOS INDUK 2
        graph.edge[18].weight =998.10; // BOBOT

        graph.edge[19].src = 14; // G. OBOS INDUK
        graph.edge[19].dest = 17; // MESJID RAYA DARUSALLAM
        graph.edge[19].weight = 1960; // BOBOT

        graph.edge[20].src = 15; // G. OBOS VII
        graph.edge[20].dest = 17; // MESJID RAYA DARUSALLAM
        graph.edge[20].weight = 1130 ; // BOBOT

        graph.edge[21].src = 16; // G. OBOS INDUK 2
        graph.edge[21].dest = 17; // MESJID RAYA DARUSALLAM
        graph.edge[21].weight = 504.77; // BOBOT

        do {
            System.out.println("===== RESPONSI ALPRO II =====");
            System.out.println("======= Menu ========");
            System.out.println("1. Mencari Satu Shortest Path");
            System.out.println("2. Exit");
            System.out.print("Masukan Menu : ");
            selectedMenu = Integer.valueOf(input.readLine());
            switch (selectedMenu) {
                case 1:
                System.out.println("JURUSAN TI UPR = 0");
                System.out.println("JALUR DEPAN = 1");
                System.out.println("JALUR BELAKANG = 2");
                System.out.println("HENDRIK TIMMANG KANAN = 3");
                System.out.println("HENDRIK TIMMANG KIRI = 4");
                System.out.println("JALUR BELAKANG KIRI = 5");
                System.out.println("GERBANG UPR = 6");
                System.out.println("BUKIT KEMINTING (HENDRIK TIMMANG) = 7");
                System.out.println("BUKIT KEMINTING (JALUR BELAKANG) = 8");
                System.out.println("YOS SUDARSO INDUK = 9");
                System.out.println("YOS SUDARSO INDUK 2 = 10");
                System.out.println("GALAXY RAYA = 11");
                System.out.println("YOS SUDARSO VI = 12");
                System.out.println("G. OBOS XII = 13");
                System.out.println("G. OBOS INDUK = 14");
                System.out.println("G. OBOS VII = 15");
                System.out.println("G. OBOS INDUK 2 = 16");
                System.out.println("MESJID RAYA DARUSALLAM = 17");
                System.out.println(" ");

                    satu(graph, masuk);
                    System.out.println("");
                case 2:
                    System.out.println("Terima Kasih");
                    break;

                default:
                    System.out.println("Pilihan salah!");
            }
        } while (selectedMenu != 2);

    }
}