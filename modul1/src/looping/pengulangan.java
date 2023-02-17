package looping;

public class pengulangan {

	public static void main(String[] args) {
		int a,b,c;
		
		System.out.println("Pengulangan While");
		a=1;
		while (a <= 15) {
			System.out.println("Angka Ke - "+a+"");
			a++;
		}
		System.out.println("");
		System.out.println("Pengulangan Do-While");
		b=1;
		do {
			System.out.println("Angka Ke - "+b+"");
			b++;
		} while(b <= 15);
		System.out.println("");
		System.out.println("Pengulangan For");
		 for (c=1;c<=15;c++) {
			 System.out.println("Angka Ke - "+c+"");
		 }
	}

}
