package modul1;

import java.util.Scanner;
public class fibonacci{

  static int fibo(int n){
    if(n == 0 || n == 1){
      return n;
    } else {
      return (fibo(n-1) + fibo(n-2));
    }
  }
  public static void main(String[]args){
    int i = 0, hasil = 1;
    Scanner Inputuser = new Scanner(System.in);
    System.out.print("Masukkan jumlah deret bilangan fibonacci: ");
    int n = Inputuser.nextInt();
    Inputuser.close();
    System.out.print("Hasil bilangan fibonacci: ");
    for (i = 0; i < n; i++){
      System.out.print(fibo(hasil)+", ");
      hasil++;
    }
    System.out.println();
  }
}

