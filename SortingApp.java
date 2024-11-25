import java.util.Scanner;

public class SortingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Meminta input angka dari pengguna
        System.out.print("Masukkan angka (pisahkan dengan koma): ");
        String inputText = scanner.nextLine();
        
        // Parsing input menjadi array of integers
        String[] inputArray = inputText.split(",");
        int[] numbers = new int[inputArray.length];
        try {
            for (int i = 0; i < inputArray.length; i++) {
                numbers[i] = Integer.parseInt(inputArray[i].trim());
            }
        } catch (NumberFormatException ex) {
            System.out.println("Masukkan hanya angka yang valid!");
            return;
        }
        
        // Memilih metode sorting
        System.out.println("Pilih metode sorting:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.print("Masukkan pilihan (1 atau 2): ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                bubbleSort(numbers);
                System.out.println("Hasil Bubble Sort:");
                break;
            case 2:
                selectionSort(numbers);
                System.out.println("Hasil Selection Sort:");
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }
        
        // Menampilkan hasil
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
    
    // Method untuk Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] dan array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    // Method untuk Selection Sort
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap array[i] dan array[minIndex]
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
