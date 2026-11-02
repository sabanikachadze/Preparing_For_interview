package org.example.DSA;

public class Parser {
    record Person(String name, int age, String email) {
    }

    Person parsePerson(String line) {

        if (line == null) {
            throw new IllegalArgumentException("line is null");
        }

        String[] fields = line.split(";", -1);

        if (fields.length != 3) {
            throw new IllegalArgumentException("Expected fields but got " + fields.length);
        }

        String name = fields[0].trim();
        String age = fields[1].trim();
        String email = fields[2].trim();

        if (name.isBlank()) {
            throw new IllegalArgumentException("name is blank");
        }


        if (!isNumber(age)) {
            throw new IllegalArgumentException("age is not a number: " + age);
        }

        int realAge = Integer.parseInt(age);

        if (realAge < 16 || realAge > 100) {
            throw new IllegalArgumentException("age out of range: " + age);
        }

        if (!email.contains("@")){
            throw new IllegalArgumentException("email has no @: " + email);
        }

            return new Person(name, realAge , email);
    }


    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
