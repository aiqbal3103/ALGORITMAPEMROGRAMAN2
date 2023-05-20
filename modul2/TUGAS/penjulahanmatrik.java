package modul2.TUGAS;

public class penjulahanmatrik {
        public static void main(String[] args) {
            int[][] A = {{1, 2, 3}, {4, 5, 6}}; // matriks A
            int[][] B = {{7, 8, 9}, {10, 11, 12}}; // matriks B
            int[][] C = new int[2][3]; // matriks hasil penjumlahan
            
            // menjumlahkan matriks A dan B
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    C[i][j] = A[i][j] + B[i][j];
                }
            }
            
            // menampilkan hasil penjumlahan
            System.out.println("Hasil penjumlahan matriks A dan B:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    

