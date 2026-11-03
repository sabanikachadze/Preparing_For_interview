package org.example.DSA;

import org.example.Pojos.Employee;

import java.util.Comparator;
import java.util.List;

public class TopEarners {

    public static List<Employee> topEarners(List<Employee> staff, String dept, int n){
        if (n < 0){
            throw new IllegalArgumentException();
        }

        return staff.stream()
                .filter( e -> e.dept().equals(dept))
                .sorted(Comparator.comparingInt(Employee::salary)
                                   .thenComparing(Employee::name))
                .limit(n)
                .toList();
    }
}
