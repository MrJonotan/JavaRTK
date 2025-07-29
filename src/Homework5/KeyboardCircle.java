package Homework5;

import java.util.HashMap;
import java.util.Scanner;

public class KeyboardCircle {
    public static void main(String[] args){
        System.out.print("Enter one symbol");
        Scanner sc = new Scanner(System.in);
        String entered_symbol = sc.next();
        char new_symbol = changeSymbol(entered_symbol.charAt(0));
        System.out.print(new_symbol);
        sc.close();
    }

    private static char changeSymbol(char symbol){
        HashMap<Character, Character> replacements = new HashMap<>();
        replacements.put('q', 'm');
        replacements.put('w', 'q');
        replacements.put('e', 'w');
        replacements.put('r', 'e');
        replacements.put('t', 'r');
        replacements.put('y', 't');
        replacements.put('u', 'y');
        replacements.put('i', 'u');
        replacements.put('o', 'i');
        replacements.put('p', 'o');
        replacements.put('a', 'p');
        replacements.put('s', 'a');
        replacements.put('d', 's');
        replacements.put('f', 'd');
        replacements.put('g', 'f');
        replacements.put('h', 'g');
        replacements.put('j', 'h');
        replacements.put('k', 'j');
        replacements.put('l', 'k');
        replacements.put('z', 'l');
        replacements.put('x', 'z');
        replacements.put('c', 'x');
        replacements.put('v', 'c');
        replacements.put('b', 'v');
        replacements.put('n', 'b');
        replacements.put('m', 'n');
        if(replacements.containsKey(symbol)){
            return replacements.get(symbol);
        }else{
            return symbol;
        }
    }
}
