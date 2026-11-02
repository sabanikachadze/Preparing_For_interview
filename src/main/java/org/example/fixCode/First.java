package org.example.fixCode;

public class First {

    private static final StringBuilder report = new StringBuilder();

    static String receipt(String item, int price) {
        report.append(item).append(": ").append(price).append(" GEL");
        return report.toString();
    }

    public static void main(String[] args) {
        System.out.println(receipt("book", 20));
        System.out.println(receipt("pen", 5));
    }


    static String receiptFix(String item, int price) {
        StringBuilder stBuilder = new StringBuilder();
        stBuilder.append(item).append(": ").append(price).append(" GEL");

        return String.valueOf(stBuilder);
    }

}
