package Homework3;

import java.util.Random;

public class Game {
    public static void main(String[] args){
        Random rand = new Random();
        int vasily = rand.nextInt(0,3);
        int peter = rand.nextInt(0,3);
        String selectVasiliy = convertMore(vasily);
        String selectPeter = convertMore(peter);
        System.out.println("Peter: " + selectPeter + " vs " + "Vasily: " + selectVasiliy );
        if(vasily == peter){
            System.out.println("Draw");
        }else if((vasily == 0 && peter == 1) || (vasily == 1 && peter == 2) || (vasily == 2 && peter == 0)){
            System.out.println("Vasily win!");
        }else{
            System.out.println("Peter win!");
        }
    }

    private static String convertMore(int move) {
        return switch (move) {
            case 0 -> "Stone";
            case 1 -> "Scissors";
            case 2 -> "Paper";
            default -> "Unknow";
        };
    }
}