package modul1;

public class soalno3{
    public static void clearScreen() { 
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); }
    public static void main(String[] args) {
        int a,b,c;
        clearScreen();
		System.out.println("Pengulangan While : ");
		a=1;
		while (a <= 15) {
			System.out.print( a +", ");
			a++;
		}
		System.out.println("");
		System.out.println("Pengulangan Do-While : ");
		b=1;
		do {
			System.out.print( b +", ");
			b++;
		} while(b <= 15);
		System.out.println("");
		System.out.println("Pengulangan For : ");
		 for (c=1;c<=15;c++) {
			 System.out.print( c +", ");
		 }
	}
}
