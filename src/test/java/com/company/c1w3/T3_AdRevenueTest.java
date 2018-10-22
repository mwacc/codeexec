package com.company.c1w3;

import org.junit.Test;

import static org.junit.Assert.*;

public class T3_AdRevenueTest {

    @Test
    public void testMaxRevenue1() {
        int totalValue = new T3_AdRevenue().maxRevenue(new int[]{23},
                                        new int[]{39});
        assertEquals(897, totalValue);
    }

    @Test
    public void testMaxRevenue2() {
        int totalValue = new T3_AdRevenue().maxRevenue(new int[]{1, 3, -5},
                                                         new int[]{-2, 4, 1});
        assertEquals(23, totalValue);
    }
}