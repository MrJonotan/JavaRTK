package Homework5;

import java.util.Scanner;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        System.out.println("Enter two words");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.toLowerCase().split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = selectionSort(words[i]);
        }
        System.out.println(String.join(" ", words));
        sc.close();
    }

    public static String selectionSort(String input) {
        char[] inputChars = input.toCharArray();
        char[] unsorted = Arrays.copyOf(inputChars, inputChars.length);
        char[] sorted = new char[inputChars.length];
        int sortedPos = 0;

        while (unsorted.length > 0) {
            char smallest = unsorted[0];
            int smallestIdx = 0;
            for (int i = 1; i < unsorted.length; i++) {
                if (unsorted[i] < smallest) {
                    smallest = unsorted[i];
                    smallestIdx = i;
                }
            }
            sorted[sortedPos++] = smallest;
            char[] temp = new char[unsorted.length - 1];
            for (int i = 0, j = 0; i < unsorted.length; i++) {
                if (i == smallestIdx) continue;
                temp[j++] = unsorted[i];
            }
            unsorted = temp;
        }
        return new String(sorted);
    }

}
