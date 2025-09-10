package Homework8;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PowerfulSet {

    public <T> Set<T> intersection(Set<T> set1, Set<T> set2){
        return set1.stream()
                .filter(e -> set2.contains(e))
                .collect(Collectors.toSet());
    }

    public <T> Set<T> union(Set<T> set1, Set<T> set2){
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2){
        return set1.stream()
                .filter(e -> !set2.contains(e))
                .collect(Collectors.toSet());
    }
}
