class MedianFinder {
    private Queue<Integer> big, small;

    public MedianFinder() {
        big = new PriorityQueue<>();
        small = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if(big.size() != small.size()){
            big.add(num);
            small.add(big.poll());
        }else{
            small.add(num);
            big.add(small.poll());
        }
    }

    public double findMedian() {
        if(big.size() == small.size()){
            return (double)(big.peek() + small.peek()) / 2;
        }else{
            return (double)big.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */