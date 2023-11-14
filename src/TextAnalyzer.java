import java.util.ArrayList;
import java.util.Scanner;

public class TextAnalyzer {
    private static String text = "";
    private static ArrayList<String> words;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== MENU TEKS ANALYZER ===");
            System.out.println("1. Masukkan Teks");
            System.out.println("2. Hitung Jumlah Karakter");
            System.out.println("3. Hitung Jumlah Kata");
            System.out.println("4. Cari Kata dalam Teks");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inputText(scanner);
                    break;
                case 2:
                    countCharacters();
                    break;
                case 3:
                    countWords();
                    break;
                case 4:
                    searchWord(scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program Teks Analisis!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    private static void inputText(Scanner scanner) {
        System.out.print("Masukkan teks: ");
        text = scanner.nextLine();
        words = new ArrayList<>();
        String[] wordArray = text.split("\\s+");
        for (String word : wordArray) {
            words.add(word.toLowerCase());
        }
        System.out.println("Teks telah dimasukkan!");
    }

    private static void countCharacters() {
        int characterCount = text.length();
        System.out.println("Jumlah karakter dalam teks: " + characterCount);
    }

    private static void countWords() {
        int wordCount = words.size();
        System.out.println("Jumlah kata dalam teks: " + wordCount);
    }

    private static void searchWord(Scanner scanner) {
        System.out.print("Masukkan kata yang ingin dicari: ");
        String searchWord = scanner.nextLine().toLowerCase();

        int occurrences = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(searchWord)) {
                occurrences++;
            }
        }

        System.out.println("Kata '" + searchWord + "' ditemukan sebanyak " + occurrences + " kali dalam teks.");
    }
}
