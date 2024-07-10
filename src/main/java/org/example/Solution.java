package org.example;

import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int here : asteroids) {
            if (s.isEmpty() || here > 0) {
                s.push(here);
            } else {
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(here)) {
                    s.pop();
                }
                if (!s.isEmpty() && s.peek() == Math.abs(here)) {
                    s.pop();
                } else {
                    if (s.isEmpty() || s.peek() < 0) {
                        s.push(here);
                    }
                }
            }
        }
        int[] result = new int[s.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = s.pop();
        }
        return result;
    }
}
