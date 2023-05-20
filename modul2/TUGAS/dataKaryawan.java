package modul2.TUGAS;

import modul2.arrayKaryawan.myinput;

public class dataKaryawan {
    private String[] nik = new String[100];
    private String[] nama = new String[100];
    private int[] gapok = new int[100];
    private int n;

    public void setNIK(int i, String h) {
        this.nik[i] = h;
    }

    public void setNama(int i, String h) {
        this.nama[i] = h;
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

    public void setJmlKaryawan(int i) {
        this.n = i;
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


    public static void main(String[] args){
        int i;
        dataKaryawan datakar = new dataKaryawan();
        myinput input1 = new myinput();
        
        System.out.println("Berapa jumlah karyawan: ");
        datakar.setJmlKaryawan(input1.bacaInt() );
        for (i=0; i<datakar.n; i++) {
            System.out.println("Karyawan ke- " + (i+1));
            System.out.println("Masukkan NIK: ");
            datakar.setNIK(i, input1.bacaString() );
            System.out.println("Masukkan Nama: ");
            datakar.setNama(i, input1.bacaString());
            System.out.println("Masukkan Gaji Pokok: ");
            datakar.setGapok(i, input1.bacaInt());
        }
        
        datakar.tampilData();
    }
}
  

// Penulisan huruf besar pada awal class.
// Penulisan variabel instance nik, nama, dan gapok sebagai array.
// Penulisan private pada variabel instance.
// Penulisan method setNIK, setNama, dan setGapok yang benar.
// Penulisan method rerataGapok yang mengembalikan nilai float.
// Penulisan parameter method rerataGapok yang tidak diperlukan.
// Penulisan for loop dengan benar pada method tampilData.
// Penambahan escape character pada string yang di-print pada method tampilData.