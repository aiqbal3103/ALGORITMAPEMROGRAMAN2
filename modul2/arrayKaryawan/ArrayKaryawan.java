package modul2.arrayKaryawan;

public class ArrayKaryawan {
    public static void main(String[] args) {
        dataKaryawan dataKar = new dataKaryawan();
        myinput input1 = new myinput();
        System.out.print("Berapa jumlah karyawan: ");
        dataKar.setJmlKaryawan(input1.bacaInt());
        for (int i = 0; i < dataKar.n; i++) {
            System.out.println("Karyawan ke- " + (i + 1));
            System.out.print("Masukan NIK : ");
            dataKar.setNIK(i, input1.bacaString());
            System.out.print("Masukan Nama : ");
            dataKar.setNama(i, input1.bacaString());
            System.out.print("Masukan Gaji Pokok : ");
            dataKar.setGapok(i, input1.bacaInt());
        }
        dataKar.tampilData();
    }
}

