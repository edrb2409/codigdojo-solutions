package com.nagarosoft.app.dojo.arrays.newyearchaos;

import java.util.Arrays;

public class NewYearChaos {

    public String minimumBribes(int[] queue) {
        int[] diff = new int[queue.length];

        for (int i = 0; i < queue.length; i++) {
            diff[i] = Math.abs(queue[i] - (i + 1));
        }

        if(Arrays.stream(diff).anyMatch(it -> it > queue.length / 2)) {
            return "Too chaotic";
        } else {
            return String.valueOf(new Double(Arrays.stream(diff).sum() / 2).intValue());
        }
    }

}
