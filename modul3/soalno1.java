package modul3;

public class soalno1 {
        public static void main(String[] args) {
            String[][] nama = { { "Jaguar", "1.340.000.000" }, { "Lamborgini", "34.500.000.000" },
                    { "Honda", "350.000.000" }, { "Audi", "2.000.000.000" }, { "Suzuki", "245.000.000" },
                    { "Mazda", "500.000.000" }, { "Daihatsu", "169.000.000" }, { "Ford", "789.000.000" },
                    { "Hyundai", "122.900.000" }, { "Mitsubishi", "278.100.000" } };
    
            for (int x = 0; x < nama.length; x++) {
    
                System.out.println("nama  : " + nama[x][0]);
                System.out.println("harga : Rp." + nama[x][1]);
                System.out.println("-------------------------------");
            }
        } 
    }

