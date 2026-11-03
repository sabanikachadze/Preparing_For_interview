package org.example;


import org.example.Pojos.Employee;

import java.util.*;

import static org.example.DSA.TopEarners.topEarners;


public class Main {
    static class Money {
        private final long cents;
        private final String currency;

        Money(long cents, String currency) {
            this.cents = cents;
            this.currency = currency;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Money money = (Money) o;
            return cents == money.cents && Objects.equals(currency, money.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cents, currency);
        }
    }

        public static void main(String[] args) {
            Money x = new Money(500, "GEL");
            Money y = new Money(500, "GEL");
            Set<Money> set = new HashSet<>();
            set.add(x);
            set.add(y);
            System.out.println(set.size() + " " + x.equals(y) + " " + x.equals((Object) y));
        }
}
