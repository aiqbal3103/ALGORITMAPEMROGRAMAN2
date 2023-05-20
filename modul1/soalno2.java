package modul1;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class soalno2 {
    public static void clearScreen() { 
        System.out.print("\033[H\033[2J"); 
        System.out.flush();          
        }
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		DecimalFormat RpIndo = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols Rp = new DecimalFormatSymbols();
		double Pajak, FreePajak;
		int n;
        clearScreen();
		
		System.out.println("==============================");
		System.out.println("MENGHITUNG GAJI BERSIH PEGAWAI");
		System.out.println("------------------------------");
		System.out.print("Masukkan Gaji : "); n = input.nextInt();
		System.out.println("==============================");
		
		Rp.setCurrencySymbol("Rp. ");
		Rp.setMonetaryDecimalSeparator(',');
		Rp.setGroupingSeparator('.');
		RpIndo.setDecimalFormatSymbols(Rp);
		
		Pajak = 0.05*(n);
		FreePajak = n-Pajak;
		
		System.out.println("GAJI BERSIH : "+RpIndo.format(FreePajak));
		System.out.println("==============================");
		input.close();
	}
}
