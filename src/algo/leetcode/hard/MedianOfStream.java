package algo.leetcode.hard;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 *      https://leetcode.com/problems/find-median-from-data-stream/
 */

/**
 * Your MedianOfStream object will be instantiated and called as such:
 * MedianOfStream obj = new MedianOfStream();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class MedianOfStream {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianOfStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((e1, e2) -> e2-e1);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        if (maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        return maxHeap.size() != minHeap.size() ? maxHeap.peek()
                : (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }
}