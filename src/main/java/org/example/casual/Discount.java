package org.example.casual;

public class Discount {

    int discountFor(int total) {
        if (total < 0) throw new IllegalArgumentException("negative total");
        if (total < 100) return 0;
        return total / 10;   // 10% of the total, as a whole number
    }
}
