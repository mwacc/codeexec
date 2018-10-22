package com.company.c1w3;

import org.junit.Assert;
import org.junit.Test;

public class T2_MaxItemsTest {

    @Test
    public void testCalcSample1() {
        double totalValue = new T2_MaxItems().calc(50,
                new int[]{60, 100, 120},
                new int[]{20, 50, 30});
        Assert.assertTrue( "Foud value: " + totalValue,Math.abs(180 - totalValue) < 0.001);
    }

    @Test
    public void testCalcSample2() {
        double totalValue = new T2_MaxItems().calc(10,
                new int[]{500},
                new int[]{30});
        Assert.assertTrue( "Foud value: " + totalValue,Math.abs(160 - totalValue) < 0.001);
    }
}
