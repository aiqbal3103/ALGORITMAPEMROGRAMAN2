package modul2.arrayKaryawan;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class myinput {
    public String bacaString() {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1);
        String string = " ";
        try {
            string = bfr.readLine();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return string;
    }

    public int bacaInt() {
        return Integer.parseInt(bacaString());
    }
}



// Penghapusan parameter kedua pada pembuatan objek BufferedReader.
// Penulisan try-catch dengan benar. 





