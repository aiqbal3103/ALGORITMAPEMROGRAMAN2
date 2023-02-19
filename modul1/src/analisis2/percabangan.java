package analisis2;
import java.util.Scanner;

public class percabangan {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int b;
		
		System.out.print("NIlai B Adalah (1 atau 2) : "); b = input.nextInt();
		if (b == 1) {
			System.out.print("Nilai Variabel B Adalah 1");
		}else if(b == 2) {
			System.out.print("Nilai VAriabel B Adalah 2");
		}
		input.close();
	}

}
