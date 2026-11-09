package org.example.DSA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DomainCounter {

    public static Map<String, Long> countByDomain(List<String> emails){
        Map<String, Long> count = new TreeMap<>();

        for (String e : emails){
            int i = e.indexOf("@");
            count.merge(e.substring(i).toLowerCase(), 1L, Long::sum);
        }

        return count;
    }

}
