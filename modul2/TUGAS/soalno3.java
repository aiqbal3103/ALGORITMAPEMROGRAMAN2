package modul2.TUGAS;
import java.util.Scanner;

public class soalno3 {
    public static void main(String[] args) {
        int jumlahdata;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah bilangan: ");
        jumlahdata = input.nextInt();
        String[] arr = new String[jumlahdata];
        System.out.print("Masukkan bilangan: ");
        for (int n = 0; n < jumlahdata; n++) {
            arr[n] = input.next();
        }

        // Sorting
        mergeSort(arr, 0, jumlahdata - 1);

        System.out.println("Bilangan setelah diurutkan (ascending):");
        for (int n = 0; n < jumlahdata; n++) {
            System.out.print(arr[n] + " ");
        }
        
        // Reverse sorting
        System.out.println("\nBilangan setelah diurutkan (descending):");
        for (int n = jumlahdata-1; n >= 0; n--) {
            System.out.print(arr[n] + " ");
        }

        input.close();
    }

    public static void mergeSort(String[] arr, int kiri, int kanan) {
        if (kiri < kanan) {
            int gabungan = (kiri + kanan) / 2;
            mergeSort(arr, kiri, gabungan);
            mergeSort(arr, gabungan + 1, kanan);
            merge(arr, kiri, gabungan, kanan);
        }
    }

    public static void merge(String[] arr, int kiri, int gabungan, int kanan) {
        int n1 = gabungan - kiri + 1;
        int n2 = kanan - gabungan;
        String[] leftArr = new String[n1];
        String[] rightArr = new String[n2];
        for (int n = 0; n < n1; n++) {
            leftArr[n] = arr[kiri + n];
        }
        for (int m = 0; m < n2; m++) {
            rightArr[m] = arr[gabungan + 1 + m];
        }
        int n = 0, m = 0, k = kiri;
        while (n < n1 && m < n2) {
            if (leftArr[n].compareTo(rightArr[m]) <= 0) {
                arr[k] = leftArr[n];
                n++;
            } else {
                arr[k] = rightArr[m];
                m++;
            }
            k++;
        }
        while (n < n1) {
            arr[k] = leftArr[n];
            n++;
            k++;
        }
        while (m < n2) {
            arr[k] = rightArr[m];
            m++;
            k++;
        }
    }
}
