// class MedianFinder {
//     private List<Integer> list;
//     private int len;

//     public MedianFinder() {
//         list = new ArrayList<>();
//         len = 0;
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//         Collections.sort(list);
//         len++;
//     }
    
//     public double findMedian() {
//         if (len % 2 != 0) {
//             return (double)list.get(len / 2);
//         } else {
//             return (double)(list.get(len / 2) + list.get(len / 2 - 1)) / 2;
//         }
//     }
// }






class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }

        return ((double) left.peek() + right.peek()) / 2;
    }
}
