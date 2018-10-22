package com.company.c1w3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
 *
 Input Format. The first line of the input contains the number 𝑛 of kind of items and the capacity 𝑊 of a knapsack.
 The next 𝑛 lines define the values and # of units of the items. The 𝑖-th line contains integers 𝑣𝑖 and 𝑤𝑖—the
 value and the # of units of 𝑖-th item, respectively.

 Output Format. Output the maximal value of fractions of items that fit into the knapsack.
 */
public class T2_MaxItems {

    public double calc(int capacity, int[] values, int[] weights) {
        Item[] valuePerUnit = getValuePerUnit(values, weights);

        int availableCapacity = capacity;
        double totalValue = 0;
        for (int i = 0; i < valuePerUnit.length && availableCapacity > 0; i++) {
            Item item = valuePerUnit[i];
            for(int j = 0; j < item.getUnits() && availableCapacity > 0; j++ ){
                // add one units unit to backpack
                totalValue += item.getValuePerUnit();
                availableCapacity--;
            }
        }

        return totalValue;
    }

    private Item[] getValuePerUnit(int[] values, int[] weights) {
        Item[] valuePerUnit = new Item[values.length];

        for(int i = 0; i < values.length; i++) {
            valuePerUnit[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(valuePerUnit, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return (int)(o2.getValuePerUnit() - o1.getValuePerUnit());
            }
        });

        return valuePerUnit;
    }

    private class Item {
        private int value;
        private int units;
        private double valuePerUnit;
        public Item(int value, int weight){
            this.value = value;
            this.units = weight;
            this.valuePerUnit = value / weight;
        }

        public int getValue() {
            return value;
        }

        public int getUnits() {
            return units;
        }

        public double getValuePerUnit() {
            return valuePerUnit;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", units=" + units +
                    ", valuePerUnit=" + valuePerUnit +
                    '}';
        }
    }


}
