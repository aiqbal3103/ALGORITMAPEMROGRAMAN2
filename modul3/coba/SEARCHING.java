package modul3.coba;

import java.util.Scanner;

public class SEARCHING {
    static int x;

    static void search() {
        int[] data = { 1, 22, 33, 21, 44, 55, 66, 77, 88, 99, }; // array int
        int cari = x;
        int i;
        boolean ada = false;
        for (i = 0; i < data.length; i++) {
            if (data[i] == cari) {
                ada = true;
                break;
            }
        }

        if (ada) {
            System.out.println("--------------------------------------->>");
            System.out.println(" Data : " + cari + " Ditemukan Pada Index ke-" + i);
            System.out.println("--------------------------------------->>");
        } else {
            System.out.println("----------------------->");
            System.out.println(" Data Tidak di temukan");
            System.out.println("<-----------------------");
            System.out.println(" Data yang tersedia :");
            for (int d = 0; d < data.length; d++) {
                System.out.print(data[d] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=>------------------------------<=");
        System.out.print(" Masukkan data yang di cari : ");
        x = input.nextInt();
        input.close();
        search();
    }
}