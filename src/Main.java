import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length;

        System.out.println("Input:");
        while (true) {
            System.out.print("Masukkan panjang array: ");
            // Validasi inputan hanya boleh angka
            if (input.hasNextInt()) {
                // Inputan panjang array
                length = input.nextInt();
                input.nextLine(); // Menghilangkan buffer
            } else {
                System.out.println("Hanya boleh memasukkan bilangan bulat");
                input.nextLine(); // Menghilangkan buffer
                continue;
            }

            String numbers;

            while (true) {
                System.out.print("Masukkan elemen array (" + length + " angka dipisahkan spasi): ");
                // Inputan elemen array
                numbers = input.nextLine();
                // Validasi inputan hanya boleh menggunakan angka dan spasi
                if (numbers.matches("^[0-9\\s]+$")) {
                    numbers = numbers.replaceAll("\\s+", " "); // Menghapus spasi yang berlebihan
                    break;
                } else {
                    System.out.println("Hanya boleh memasukkan angka");
                }
            }

            // Memasukkan semua inputan kedalam array string
            String inputArray[] = numbers.split(" "); // Untuk memecah string

            // Validasi jika input elemen tidak sebanding dengan jumlah panjang array
            if (length < inputArray.length || inputArray.length < length) {
                System.out.println("Jumlah input yang anda masukkan dan panjang array tidak sama");
                continue;
            }

            // Menggunakan array untuk menyimpan data integer
            int uniqueArray[] = new int[length];
            for (int indeksString = 0; indeksString < uniqueArray.length; ++indeksString) {
                uniqueArray[indeksString] = Integer.parseInt(inputArray[indeksString]);
            }

            Arrays.sort(uniqueArray); // Fungsi untuk mengurutkan angka didalam array

            int unique = 0;

            // Looping untuk menentukan berapa pasangan angka unik yang ada
            for (int indeksUnique = 1; indeksUnique < uniqueArray.length; indeksUnique++) {
                if (uniqueArray[indeksUnique] != uniqueArray[indeksUnique - 1]) {
                    unique++;
                }
            }

            System.out.println(Arrays.toString(uniqueArray)); // Menampilkan isi array
            System.out.println("\nJumlah pasangan angka unik yang ditemukan: " + unique);
        }
    }
}