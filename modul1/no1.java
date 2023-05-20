package modul1;
public class no1{
    
    public static void clearScreen() { //deklarasi metode clearscreen
        System.out.print("\033[H\033[2J"); //untuk membersihkan layar konsol.
        System.out.flush(); //untuk memastikan output terakhir dari program di-flush (dikosongkan)         }
    }
    public static void main(String[] args) {
        clearScreen(); //memanggil fungsi clean screen
        System.out.print("HELLO");
    }
}
