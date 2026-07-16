// class MinStack {
//     private Stack<List<Integer>> stack;

//     public MinStack() {
//         stack = new Stack<>();
//     }
    
//     public void push(int val) {
//         List<Integer> list = new ArrayList<>();
//         // if (stack.isEmpty()) {
//         //     list.add(val, val);
//         // } else {
//         //     if (val < getMin()) {
//         //         list.add(val, val);
//         //     } else {
//         //         list.add(val, getMin());
//         //     }
//         // }
//         list.add(val);
//         if (stack.isEmpty() || val < getMin()) {
//             list.add(val);
//         } else {
//             list.add(getMin());
//         }
//         stack.push(list);
//     }
    
//     public void pop() {
//         stack.pop();
//     }
    
//     public int top() {
//         return stack.peek().get(0);
//     }
    
//     public int getMin() {
//         return stack.peek().get(1);
//     }
// }











class MinStack {
    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        // int[] pair = new int[2];
        // pair[0] = val;
        // if (stack.isEmpty() || val < getMin()) {
        //     pair[1] = val;
        // } else {
        //     pair[1] = getMin();
        // }
        // stack.push(pair);

        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            stack.push(new int[] {val, Math.min(val, getMin())});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
