package Homework8;

import java.util.HashSet;

public class Exercise3 {
    public static void main(String[] args){
        HashSet<Integer> numArray1 = new HashSet<> ();
        numArray1.add(1);
        numArray1.add(2);
        numArray1.add(3);

        HashSet<Integer> numArray2 = new HashSet<>();
        numArray2.add(0);
        numArray2.add(1);
        numArray2.add(2);
        numArray2.add(4);
        PowerfulSet ps = new PowerfulSet();

        System.out.println("Первый массив: " + numArray1.toString() + "\nВторой массив: " + numArray2.toString() +
                "\nПересечение: \n" + ps.intersection(numArray1, numArray2) +
                "\nОбъединение: \n" + ps.union(numArray1, numArray2) +
                "\nОтносительное дополнение: \n" + ps.relativeComplement(numArray1, numArray2)
        );
//        System.out.println("Пересечение: \n" + "\nВторой массив: " + numArray2.toString());
    }
}
