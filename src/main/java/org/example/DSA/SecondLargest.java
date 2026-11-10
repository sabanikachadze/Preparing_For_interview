package org.example.DSA;

public class SecondLargest {

    public static void main(String[] args){

        System.out.println(secondLargest(new int[]{5}));
    }

    static int secondLargest(int[] nums) {

        int largest = nums[0];
        int secondLargest = nums[0];
        boolean found = false;

        for (int num : nums) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;
                found = true;
            }

            if (num == largest) {
                continue;
            }

            if (!found || num > secondLargest) {
                secondLargest = num;
                found = true;
            }

        }

        if (!found) {
            throw new IllegalArgumentException();
        } else {
            return secondLargest;
        }
    }

}
