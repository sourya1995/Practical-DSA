/*
 * Feature 7 - Browse Ratings - PROBLEM - Max Stack
 */



public class MaxStack {
    int maxSize;
    Stack<Integer> mainStack;
    Stack<Integer> maxStack;

    public MaxStack(int maxSize){
        this.maxSize = maxSize;
        mainStack = new Stack<>(maxSize);
        maxStack = new Stack<>(maxSize);
    }

    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    public void push(Integer value) {
        mainStack.push(value);
        if(!maxStack.isEmpty() && maxStack.top() > value)
            maxStack.push(maxStack.top());
        else
            maxStack.push(value);
    }

    public int maxRating(){
        return maxStack.top();
    }



}
