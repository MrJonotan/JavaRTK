package Homework8;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введете первую строку");
        String firstWord = sc.nextLine();
        System.out.println("Введете вторую строку");
        String secondWord = sc.nextLine();
        System.out.println(anagramCheck(firstWord, secondWord));
    }

    public static boolean anagramCheck (String firstWord, String secondWord){
        if(firstWord.length() != secondWord.length()){
            return false;
        }
        String sorted1 = String.valueOf(firstWord.toLowerCase()
                .chars()
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString());
        String sorted2 = String.valueOf(secondWord.toLowerCase()
                .chars()
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString());
        return sorted1.equals(sorted2);
    }
}
