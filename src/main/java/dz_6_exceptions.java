import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class dz_6_exceptions {

    public static void main(String[] args) throws IOException {

        int[] testArray = {10, 20, 30, 40, 50};

        System.out.println("Правильный вывод: ");
        printArray(testArray, 0, 5);
        System.out.println("\nВывод с ошибкой: ");
        printArray(testArray, 10, 15);


        String path = "/Users/serg/IdeaProjects/hillel-6-dz/sometext.txt";
        /* ---------------------------------------------
           | Если изменить путь по нахождению файла    |
           | то как раз выбьет - java.io.IOException . |
           --------------------------------------------- */

        File file = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line + "\n");
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static void printArray(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            try {
                System.out.print(array[i] + " ");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Исключение. Обращение к несуществующему индексу: " +
                        i + "; массива: testArray; c длиной: " + array.length + ".");
                break;
            }
        }
    }
}