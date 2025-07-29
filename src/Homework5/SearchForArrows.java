package Homework5;

import java.util.Scanner;

public class SearchForArrows {
    public static void main(String[] args){
        System.out.println("Enter a string consisting of the characters '<','>','-'");
        Scanner sc = new Scanner(System.in);
        String arrowsString = sc.next();
        char[] symbols = arrowsString.toCharArray();
        int counterArrow = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i <= symbols.length; i++){
            if(symbols.length - i > 5) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(symbols, i, 5);
                String arrow = stringBuilder.toString();
                if (arrow.equals(">>-->") || arrow.equals("<--<<")) {
                    counterArrow++;
                }
            }
        }
        sc.close();
        System.out.print("Found arrows: " + counterArrow);
    }
}
