package com.company.c1w3;

import org.junit.Test;

import static org.junit.Assert.*;

public class T4_TenantsTest {

    @Test
    public void findOverlaps1() {
        int[] points = new T4_Tenants().findOverlaps(
                                        new int[][]{{1,3},
                                                    {2,5},
                                                    {3,6}});
        assertEquals(1, points.length);
        assertEquals(3, points[0]);
    }

    @Test
    public void findOverlaps2() {
        int[] points = new T4_Tenants().findOverlaps(
                                        new int[][]{{4,7},
                                                    {1,3},
                                                    {2,5},
                                                    {5,6}});
        assertEquals(2, points.length);
        assertEquals(3, points[0]);
        assertEquals(6, points[1]);
    }

}