package com.nagarosoft.app.dojo.arrays.pickNumbers;

import java.util.Collections;
import java.util.List;

public class PickingNumbers {


    public static int pickingNumbers(List<Integer> elements) {

        if(elements.size() == 1) return 1;

        Collections.sort(elements);

        int max = 0;

        for(int i = 1; i < elements.size(); i++) {

            int pivot = elements.get(i);
            int count = 0;

            for(int j = i -1; j < elements.size(); j++) {
                int current = elements.get(j);
                int safe = 0;

                if(Math.abs(pivot - current) <= 1)
                    ++count;
                else
                    break;

                if( j > 1) {
                    safe = elements.get(j - 2);
                    if (pivot != current && Math.abs(current - safe) > 1) {
                        --count;
                        break;
                    }
                }

            }
            System.out.printf("count-> %d, i-> %d, pivot -> %d\n",count, i, pivot);
            max = max < count ? count : max;
        }

        return max;
    }

}
