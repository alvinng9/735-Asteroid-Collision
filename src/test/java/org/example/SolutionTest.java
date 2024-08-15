package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void asteroidCollisionTest() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{5, 10}, solution.asteroidCollision(new int[]{5, 10, -5}));
        assertArrayEquals(new int[]{}, solution.asteroidCollision(new int[]{8, -8}));
        assertArrayEquals(new int[]{10}, solution.asteroidCollision(new int[]{10, 2, -5}));
        assertArrayEquals(new int[]{}, solution.asteroidCollision(new int[]{10, 2, -5, -10}));
        assertArrayEquals(new int[]{10, 10}, solution.asteroidCollision(new int[]{10, 2, -5, 10}));
    }
}