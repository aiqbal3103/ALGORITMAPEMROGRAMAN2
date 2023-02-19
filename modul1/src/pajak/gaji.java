package pajak;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class gaji {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		DecimalFormat RpIndo = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols Rp = new DecimalFormatSymbols();
		double Pajak, FreePajak;
		int n;
		
		System.out.println("==============================");
		System.out.println("MENGHITUNG GAJI BERSIH PEGAWAI");
		System.out.println("------------------------------");
		System.out.print("Masukkan Gaji : "); n = input.nextInt();
		System.out.println("==============================");
		
		Rp.setCurrencySymbol("Rp. ");
		Rp.setMonetaryDecimalSeparator(',');
		Rp.setGroupingSeparator('.');
		RpIndo.setDecimalFormatSymbols(Rp);
		
		Pajak = 0.09*(n);
		FreePajak = n-Pajak;
		
		System.out.println("GAJI BERSIH : "+RpIndo.format(FreePajak));
		System.out.println("==============================");
		input.close();
	}

}
