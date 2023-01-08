package sorting.questions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Q2_Sort0s1s2s {
    public static void sort012(int arr[], int n)
    {
        int part_index = 0;
        for(int i=0; i< arr.length; i++) {
            if(0 >= arr[i]){
                int temp = arr[i];
                arr[i] = arr[part_index];
                arr[part_index] = temp;
                part_index++;
            }
        }
        part_index = 0;
        for(int i=0; i< arr.length; i++) {
            if(1 >= arr[i]){
                int temp = arr[i];
                arr[i] = arr[part_index];
                arr[part_index] = temp;
                part_index++;
            }
        }
    }

    public static void main(String[] args) {
        try (
                Scanner input = new Scanner(Paths.get("src/main/resources/questions/input.txt").toFile());
                PrintWriter output = new PrintWriter(Paths.get("src/main/resources/questions/output.txt").toFile());
        ) {
            int length = input.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = input.nextInt();
            }
            sort012(arr, length);
            output.println(Arrays.toString(arr));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
