/*
 * Feature 10 - add median for buffering events - PROBLEM - Sliding Window Median
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> medians = new ArrayList<Double>();
        HashMap<Integer, Integer> outgoingNum = new HashMap<>();
        PriorityQueue<Integer> smallList = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largeList = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            smallList.offer(nums[i]);
        for (int i = 0; i < k / 2; i++)
            largeList.offer(smallList.poll());

        int balance = 0;
        int i = k;
        while (true) {
            if ((k & 1) == 1)
                medians.add((double) smallList.peek());
            else
                medians.add((double) ((long) smallList.peek() + (long) largeList.peek()) * 0.5);
            if (i >= nums.length)
                break;
            int outNum = nums[i - k];
            int inNum = nums[i];
            i++;

            if (outNum <= smallList.peek())
                balance -= 1;
            else
                balance += 1;

            if (outgoingNum.containsKey(outNum))
                outgoingNum.put(outNum, outgoingNum.get(outNum) + 1);
            else
                outgoingNum.put(outNum, 1);

            if (smallList.size() > 0 && inNum <= smallList.peek()) {
                balance += 1;
                smallList.offer(inNum);
            }

            else {
                balance -= 1;
                largeList.offer(inNum);
            }

            if (balance < 0)
                smallList.offer(largeList.poll());
            else if (balance > 0)
                largeList.offer(smallList.poll());

            balance = 0;

            while (smallList.size() > 0 && outgoingNum.containsKey(smallList.peek())
                    && outgoingNum.get(smallList.peek()) > 0)
                outgoingNum.put(smallList.peek(), outgoingNum.get(smallList.poll()) - 1);

            while (largeList.size() > 0 && outgoingNum.containsKey(largeList.peek())
                    && outgoingNum.get(largeList.peek()) > 0)
                outgoingNum.put(largeList.peek(), outgoingNum.get(largeList.poll()) - 1);

        }

        double[] arr = medians.stream().mapToDouble(Double::doubleValue).toArray();
        return arr;
    }
}