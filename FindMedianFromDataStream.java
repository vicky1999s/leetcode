package leetcode;

import java.util.PriorityQueue;

public class FindMedianFromDataStream{
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);    // arr = [1]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian());
         // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(2);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian());
        // return 2.0

    }
}

class MedianFinder {

    private PriorityQueue<Integer> maxHeap = null;
    private PriorityQueue<Integer> minHeap = null;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->(b-a));
        minHeap = new PriorityQueue<>((a,b)->(a-b));
    }
    
    public void addNum(int num) {
        if (maxHeap.size()== 0 || maxHeap.peek()>=num)
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        balance();
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else{
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

    }

    public void balance(){
        if (maxHeap.size()-minHeap.size() > 1)
            minHeap.offer(maxHeap.poll());
        else if (minHeap.size()-maxHeap.size() > 1)
            maxHeap.offer(minHeap.poll());
    }
}
