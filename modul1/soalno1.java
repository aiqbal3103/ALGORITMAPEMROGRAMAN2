package modul1;
import java.util.Scanner;
public class soalno1 {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        double a, b, c;
        int x, y;

        System.out.println("======================");
        System.out.print("Masukkan Banyak Angka : ");
        y = Input.nextInt();
        System.out.println("======================");
        System.out.println("");
        a = 0;
        x = 1;
        while (x <= y) {
            System.out.print("Angka Ke - " + x + " : ");
            b = Input.nextDouble();
            a += b;
            x++;
        }
        c = a / y;
        System.out.println("");
        System.out.println("======================");
        System.out.println("Nilai Rata Rata : " + c);
        System.out.println("======================");
        Input.close();
    }
}