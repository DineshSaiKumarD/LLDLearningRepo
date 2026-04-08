package Stacks;

import java.util.Stack;

class NextGreaterElements2 {
    public int[] nextGreaterElements(int[] arr) {

        int n = arr.length;

        System.out.println("n " + n);
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = arr[i % n];

            System.out.println("i= " + i + " n= " + n + " i%n= " + (i % n));
            System.out.println("curr " + curr);

            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            if (i < n) {
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(curr);

        }

        return ans;

    }

    public static void main(String[] args) {
        new NextGreaterElements2().nextGreaterElements(new int[]{3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9});
    }

}
