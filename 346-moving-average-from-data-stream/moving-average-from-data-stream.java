class MovingAverage {
    int sum;
    int size;
    Queue<Integer> queue;
    public MovingAverage(int size) {
        sum = 0;
        this.size = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        sum += val;
        queue.add(val);
        if(queue.size() > size){
            int minus = queue.poll();
            sum -= minus;
        }
        return sum * 1.0 / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */