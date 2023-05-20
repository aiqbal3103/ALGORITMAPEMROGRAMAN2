package modul3.coba;

public interface Int {
    public static void main(String[] args) {
        int A[] = new int[10];
        A[0] = 11;
        A[1] = 3;
        A[2] = 4;
        A[3] = 2;
        A[4] = 6;
        A[5] = 8;
        A[6] = 7;
        A[7] = 9;
        A[8] = 10;
        A[9] = 5;
        int i, j, N = 10, temp;
        System.out.println("Tampilan angka dari yang terkecil array");
        for (i = 0; i < N; i++) {
            for (j = N - 1; j > i; j--) {
                if (A[j] < A[j - 1]) {
                    temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }
        for (j = 0; j < N; j++) {
            System.out.print(" " + A [j]);
        }
        System.out.println("");
        System.out.println("Tampilan angka dari yang terbesar array");
        for (i = 0; i < N; i++) {
            for (j = N - 1; j > i; j--) {
                if (A[j] > A[j - 1]) {
                    temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }
        for (j = 0; j < N; j++) {
            System.out.print(" " + A[j]);
        }
    }

}
