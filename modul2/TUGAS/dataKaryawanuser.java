package modul2.TUGAS;
import java.util.Scanner;

public class dataKaryawanuser {

    private String[] nik = new String[100];
    private String[] nama = new String[100];
    private int[] gapok = new int[100];
    private int n;

    public void setNIK(int i, String x) {
        this.nik[i] = x;
    }

    public void setNama(int i, String x) {
        this.nama[i] = x;
    }

    public void setGapok(int i, int x) {
        this.gapok[i] = x;
    }

    public float rerataGapok() {
        int sum = 0;
        for (int i = 0; i < this.n; i++) {
            sum += this.gapok[i];
        }
        return (float) sum / this.n;
    }

    public void setJmlKaryawan(int x) {
        this.n = x;
    }

    public void tampilData() {
        System.out.println("====================================");
        System.out.println("NIK\tNAMA\tGAJI");
        System.out.println("====================================");
        for (int i = 0; i < this.n; i++) {
            System.out.println(String.format("%-5s %-35s Rp %10d", this.nik[i], this.nama[i], this.gapok[i]));
        }
        System.out.println("====================================");
        System.out.println("Rata-rata gaji pokok dari " + this.n + " karyawan adalah Rp " + this.rerataGapok());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dataKaryawanuser karyawan = new dataKaryawanuser();
        
        System.out.print("Masukkan jumlah karyawan: ");
        int jmlKaryawan = sc.nextInt();
        karyawan.setJmlKaryawan(jmlKaryawan);
        
        for (int i = 0; i < jmlKaryawan; i++) {
            System.out.println("Karyawan ke-" + (i+1));
            System.out.print("NIK: ");
            String nik = sc.next();
            karyawan.setNIK(i, nik);
            
            System.out.print("Nama: ");
            String nama = sc.next();
            karyawan.setNama(i, nama);
            
            System.out.print("Gaji: ");
            int gaji = sc.nextInt();
            karyawan.setGapok(i, gaji);
        }
        
        karyawan.tampilData();
        sc.close();
    }
}


