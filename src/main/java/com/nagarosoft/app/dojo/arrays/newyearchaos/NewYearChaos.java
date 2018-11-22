package com.nagarosoft.app.dojo.arrays.newyearchaos;

/**
 * New Year Chaos
 *
 * @see <a href="https://www.hackerrank.com/challenges/new-year-chaos/problem">Hackerrank - New Year Chaos</a>
 */
public class NewYearChaos {

    /**
     * Minimum Brides
     *
     * @param queue
     * @return
     */
    public String minimumBribes(int[] queue) {
        int numBribes = 0;

        for(int index = queue.length - 2; index >= 0; index--) {
            int j = index + 1;
            int element = queue[index];
            int movements = 0;

            while( j < queue.length && element > queue[j] ) {
                queue[j-1] = queue[j];
                j++;
                movements++;

                if( movements > 2 )
                    return "Too chaotic";
            }

            queue[j-1] = element;
            numBribes += movements;
        }

        return Integer.toString(numBribes);
    }

}
