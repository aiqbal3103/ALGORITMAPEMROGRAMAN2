package modul2.TUGAS;

import java.util.Scanner;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;

public class fungsiprosedure{
    static ArrayList<String> listBuah = new ArrayList<String>();
    static boolean isRunning = true;
    //static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static Scanner input = new Scanner(System.in);

    static void showMenu() throws IOException {
        System.out.println("========= MENU ========");
        System.out.println("[1] Show All Buah");
        System.out.println("[2] Insert Buah");
        System.out.println("[3] Edit Buah");
        System.out.println("[4] Delete Buah");
        System.out.println("[5] Exit");
        System.out.print("PILIH MENU> ");
        int selectedMenu = Integer.valueOf(input.next());
        switch (selectedMenu) {
            case 1:
                showAllBuah();
                break;
            case 2:
                insertBuah();
                break;
            case 3:
                editBuah();
                break;
            case 4:
                deleteBuah();
                break;
            case 5:
                isRunning = false;
                System.out.println("Terima kasih telah menggunakan program ini!");
                break;
            default:
                System.out.println("Pilihan salah!");
        }
    }

    static void showAllBuah() {
        if (listBuah.isEmpty()) {
            System.out.println("Belum ada data");
        } else {
            for (int i = 0; i < listBuah.size(); i++) {
                System.out.println(String.format("[%d] %s", i, listBuah.get(i)));
            }
        }
    }

    static void insertBuah() throws IOException {
        System.out.print("Nama buah: ");
        String namaBuah = input.next();
        listBuah.add(namaBuah);
    }

    static void editBuah() throws IOException {
        showAllBuah();
        System.out.print("Pilih nomer buah: ");
        int indexBuah = Integer.valueOf(input.next());
        if (indexBuah >= 0 && indexBuah < listBuah.size()) {
            System.out.print("Nama Baru: ");
            String namaBaru = input.next();
            // ubah nama buah
            listBuah.set(indexBuah, namaBaru);
        } else {
            System.out.println("Nomer buah tidak ditemukan!");
        }
    }
    static void deleteBuah() throws IOException {
        showAllBuah();
        System.out.print("Pilih nomer buah: ");
        int indexBuah = Integer.valueOf(input.next());
        if (indexBuah >= 0 && indexBuah < listBuah.size()) {
            // hapus buah
            listBuah.remove(indexBuah);
            System.out.println("Berhasil menghapus buah.");
        } else {
            System.out.println("Nomer buah tidak ditemukan!");
            
        }
        
    }
    public static void main(String[] args) throws IOException {
        do {
            showMenu();
        } while (isRunning);
    }
}
