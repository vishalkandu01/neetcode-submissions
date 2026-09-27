class MedianFinder {
    private List<Integer> list;
    private int len;

    public MedianFinder() {
        list = new ArrayList<>();
        len = 0;
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
        len++;
    }
    
    public double findMedian() {
        if (len % 2 != 0) {
            return (double)list.get(len / 2);
        } else {
            return (double)(list.get(len / 2) + list.get(len / 2 - 1)) / 2;
        }
    }
}
