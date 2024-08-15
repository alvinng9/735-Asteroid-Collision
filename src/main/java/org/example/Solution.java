package org.example;

import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //initialize a stack of integers
        Stack<Integer> stack = new Stack<>();

        //iterate through the list of asteroids
        for (int asteroid : asteroids) {
            //case when the stack is empty or the asteroid is moving in the positive direction
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {
                //case when the stack is not empty and the top asteroid is moving in the positive
                //direction while the upcoming asteroid is moving in the negative direction
                //pop all asteroids at the top of the stack that fits the criteria
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                //case when the stack is not empty and the most top asteroid has the same size
                //but moving in the opposite direction from the upcoming asteroid
                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                } else {
                    //case when the stack is empty after all the asteroids in the stack
                    //have been cancelled out
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroid);
                    }
                }
            }
        }
        //initialize an array of integers
        int[] result = new int[stack.size()];
        //insert values from the stack to the array
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        //return the array
        return result;
    }
}
