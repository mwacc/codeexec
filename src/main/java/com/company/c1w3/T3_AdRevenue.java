package com.company.c1w3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Given two sequences 𝑎1, 𝑎2, . . . , 𝑎𝑛 (𝑎𝑖 is the profit per click of the 𝑖-th ad) and 𝑏1, 𝑏2, . . . , 𝑏𝑛 (𝑏𝑖 is
 the average number of clicks per day of the 𝑖-th slot), we need to partition them into 𝑛 pairs (𝑎𝑖, 𝑏𝑗)
 such that the sum of their products is maximized.
 Input Format. The first line contains an integer 𝑛, the second one contains a sequence of integers
 𝑎1, 𝑎2, . . . , 𝑎𝑛, the third one contains a sequence of integers 𝑏1, 𝑏2, . . . , 𝑏𝑛.

 Output Format. Output the maximum value of possible revenue

 */
public class T3_AdRevenue {

    public int maxRevenue(int[] profitPerClick, int[] numberOfClicks) {
        Integer[] ppc = IntStream.of(profitPerClick).boxed().toArray(Integer[]::new);
        Integer[] noc = IntStream.of(numberOfClicks).boxed().toArray(Integer[]::new);

        Arrays.sort(ppc, Collections.reverseOrder());
        Arrays.sort(noc, Collections.reverseOrder());

        int revenue = 0;
        for(int i = 0; i < ppc.length; i++) {
            revenue += ppc[i]*noc[i];
        }
        return revenue;
    }


}
