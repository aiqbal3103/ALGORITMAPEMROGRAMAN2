package modul2.TUGAS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class myinput {
    
    public static void main(String[] args) {
        myinput myInput = new myinput();
        
        System.out.print("Masukkan nilai integer: ");
        int inputInt = myInput.bacaInt();
        System.out.println("Nilai yang Anda masukkan: " + inputInt);
        
        System.out.print("Masukkan huruf: ");
        String inputString = myInput.bacaString();
        System.out.println("String yang Anda masukkan: " + inputString);
    }
    
    public String bacaString() {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String huruf = "";
        try {
            huruf = bfr.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return huruf;}
    
    public int bacaInt() {
        return Integer.parseInt(bacaString());
    }
}


// Penulisan huruf besar pada awal class dan nama file harus sama.
// Penulisan import harus dilakukan di awal program.
// Penghapusan parameter kedua pada pembuatan objek BufferedReader.
// Penulisan try-catch dengan benar.
// Penulisan return yang benar.

// "can't find main(String[]) method in class" terjadi karena tidak adanya method main dengan parameter
//  String[] pada class myinput. 
//method main berfungsi untuk menguji kedua method bacaString dan bacaInt. Method main mencetak pesan untuk meminta inputan dari pengguna, 
//kemudian memanggil method bacaString dan bacaInt dari objek myInput. Hasil inputan kemudian dicetak kembali sebagai output.



