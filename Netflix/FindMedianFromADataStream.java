/*
 * Feature 3 - Find Median Age of viewers - PROBLEM - Find median in a data stream
 */

import java.util.PriorityQueue;

public class FindMedianFromADataStream {
    PriorityQueue<Integer> maxHeapForSmallest;
    PriorityQueue<Integer> minHeapForLargest;

    public FindMedianFromADataStream(){
        maxHeapForSmallest = new PriorityQueue<>((a, b) -> b -a);
        minHeapForLargest = new PriorityQueue<>((a, b) -> a -b );
    }

    public void addNum(int num){
        if(maxHeapForSmallest.isEmpty() || maxHeapForSmallest.peek() >= num)
            maxHeapForSmallest.add(num);
        else
            minHeapForLargest.add(num);

        if(maxHeapForSmallest.size() > minHeapForLargest.size() + 1)
            minHeapForLargest.add(maxHeapForSmallest.poll());
        else if(maxHeapForSmallest.size() < minHeapForLargest.size())
            maxHeapForSmallest.add(minHeapForLargest.poll());
    }

    public double findMedian(){
        if(maxHeapForSmallest.size() == minHeapForLargest.size()){
            return maxHeapForSmallest.peek() / 2.0 + minHeapForLargest.peek() / 2.0;

        }

        return maxHeapForSmallest.peek();
    }
}
