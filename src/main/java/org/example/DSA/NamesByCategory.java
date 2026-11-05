package org.example.DSA;

import org.example.Pojos.Product;

import java.util.*;

public class NamesByCategory {

    static Map<String, List<String>> namesByCategory(List<Product> products) {
        Map<String, List<String>> result = new TreeMap<>();

        for (Product p : products) {
            result.computeIfAbsent(p.category(), k -> new ArrayList<>()).add(p.name());
        }
        result.values().forEach(Collections::sort);

        return result;
    }

}
