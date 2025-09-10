package Homework8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise1 {
    public static void main (String[] args)
    {
        ArrayList<String> arrayWithDuplicates = new ArrayList<>();
        arrayWithDuplicates.add("apple");
        arrayWithDuplicates.add("banana");
        arrayWithDuplicates.add("apple");
        arrayWithDuplicates.add("orange");
        arrayWithDuplicates.add("banana");
        Set<String> uniqueWords = uniqueElements(arrayWithDuplicates);
        System.out.println(uniqueWords);
    }

    private static <T> Set<T> uniqueElements(ArrayList<T> list)
    {
        List<T> uniqueElements = list.stream()
                .distinct()
                .toList();
        return new HashSet<>(uniqueElements);
    }
}
