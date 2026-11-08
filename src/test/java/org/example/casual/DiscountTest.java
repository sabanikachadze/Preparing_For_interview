package org.example.casual;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    public void discountFor_throwsIllegalArgument_whenTotalIsNegative() {
        Discount discount = new Discount();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> discount.discountFor(-1));
        assertEquals("negative total", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 50, 99})
    void discountFor_returnsZero_whenTotalIsBelow100(int total) {
        Discount discount = new Discount();
        assertEquals(0, discount.discountFor(total));
    }


    @ParameterizedTest
    @CsvSource({"100, 10", "150, 15", "105, 10"})
    void discountFor_returnsTenPercent_whenTotalIs100OrMore(int total, int expected) {
        Discount discount = new Discount();
        assertEquals(expected, discount.discountFor(total));
    }
}