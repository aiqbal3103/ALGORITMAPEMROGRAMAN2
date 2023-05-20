package modul1;
import java.util.Scanner;
public class Tugas_NIMGenap{
    
    public static void clearScreen() { //deklarasi metode clearscreen
        System.out.print("\033[H\033[2J"); //untuk membersihkan layar konsol.
        System.out.flush(); //untuk memastikan output terakhir dari program di-flush (dikosongkan)         }
}
    public static void main(String[] args) {
        clearScreen(); //memanggil fungsi clean screen
        Scanner InputUser = new Scanner(System.in); //agar bisa mengambil inputan dari konsol(user)
        System.out.print("Masukan banyak bilangan Fibonacci: ");
        int data = InputUser.nextInt(); 
        InputUser.close();

        
        System.out.print("Bilangan FIbonacci : ");
        for (int i = 1; i <= data; i++) {  //pengulangan untuk bilngan fibonacci
            System.out.print(fibonacci(i) + ", ");
        }
    }
    
    public static int fibonacci(int n) { //deklarasi metode fibonacci
        if (n <= 1) {
            return n; //// basis untuk mengembalikan nilai dari n
        }
        return fibonacci(n-1) + fibonacci(n-2); //rekursif untuk mengembalikan hasil penjumlahan nilai n-1 dan n-2
    }
}







