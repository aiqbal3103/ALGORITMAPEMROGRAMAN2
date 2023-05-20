package modul1;
import java.util.Scanner;
public class faktorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan bilangan : ");
        int bilangan = input.nextInt();
        input.close();

        // memanggil metode rekursif untuk menghitung faktorial
        int hasil = hitungFaktorial(bilangan);

        System.out.println("Faktorial dari " + bilangan + " adalah " + hasil);
    }

    public static int hitungFaktorial(int n) {
        if (n == 0) {
            return 1; // basis
        } else {
            return n * hitungFaktorial(n-1); // rekursif
        }
    }
}

