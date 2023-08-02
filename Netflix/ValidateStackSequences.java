import java.util.Stack;

/*
 * Feature 8 - Verify User Sessions - PROBLEM - Verify Stack Sequences
 */

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int M = pushed.length;
        int N = popped.length;

        if(M != N)
            return false;

        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        for(int pid: pushed){
            stack.push(pid);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }

        if(stack.isEmpty())
            return true;
        return false;
    }
}