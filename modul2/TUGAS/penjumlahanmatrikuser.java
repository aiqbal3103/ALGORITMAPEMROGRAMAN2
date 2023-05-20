package modul2.TUGAS;
import java.util.Scanner;

public class penjumlahanmatrikuser {

    public static void main(String[] args) {

        int[][] A = new int[2][3]; // matriks A
        int[][] B = new int[2][3]; // matriks B
        int[][] C = new int[2][3]; // matriks hasil penjumlahan
        
        Scanner input = new Scanner(System.in);
        
        
        // meminta inputan untuk matriks A
        System.out.println("Masukkan matriks A (ukuran 2x3):");
        for (int n = 0; n < 2; n++) {
            for (int m = 0; m < 3; m++) {
                System.out.print("A[" + n + " " + m + "] = ");
                A[n][m] = input.nextInt();
            }
        }
        
        // meminta inputan untuk matriks B
        System.out.println("Masukkan matriks B (ukuran 2x3):");
        for (int n = 0; n < 2; n++) {
            for (int m = 0; m < 3; m++) {
                System.out.print("B[" + n + " " + m + "] = ");
                B[n][m] = input.nextInt();
            }
        }
        
        // menjumlahkan matriks A dan B
        for (int n = 0; n < 2; n++) {
            for (int m = 0; m < 3; m++) {
                C[n][m] = A[n][m] + B[n][m];
            }
        }
        
        // menampilkan hasil penjumlahan
    
        System.out.println("Hasil penjumlahan matriks A dan B:");
        for (int n = 0; n < 2; n++) {
            
            for (int m = 0; m < 3; m++) {
                System.out.print(C[n][m] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}

