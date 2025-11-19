class MedianFinder {
    Queue<Integer> leftHeap;
    Queue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a, b) -> b - a);
        rightHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftHeap.isEmpty() || num <= leftHeap.peek())
            leftHeap.add(num);
        else
            rightHeap.add(num);

        if (rightHeap.size() > leftHeap.size() + 1)
            leftHeap.add(rightHeap.poll());

        if (leftHeap.size() > rightHeap.size() + 1)
            rightHeap.add(leftHeap.poll());
    }

    public double findMedian() {
        if (leftHeap.size() > rightHeap.size())
            return leftHeap.peek();
        else if (leftHeap.size() < rightHeap.size())
            return rightHeap.peek();
        else
            return (leftHeap.peek() + rightHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */