package org.example.DSA;

public class LastOccurrence {

    public static int lastOccurrence(int[] sorted, int target){
        int currentIndex =-1;

        for (int i = 0; i < sorted.length; i++){
            if (sorted[i] == target){
                currentIndex = i;
            }
        }

        return currentIndex;
    }
}
