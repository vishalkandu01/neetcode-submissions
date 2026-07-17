class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // int len = temperatures.length;
        // int[] results = new int[len];

        // for (int i = 0; i < len - 1; i++) {
        //     int day = 0;
        //     for (int j = i + 1; j < len; j++) {
        //         day++;
        //         if (temperatures[i] < temperatures[j]) {
        //             results[i] = day;
        //             break;
        //         }
        //     }
        // }

        // return results;



        int len = temperatures.length;
        int[] results = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            // if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
            //     stack.push(i);
            // } else {
            //     while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
            //         results[stack.peek()] = i - stack.peek();
            //         stack.pop();
            //     }
            //     stack.push(i);
            // }


            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                // results[stack.peek()] = i - stack.peek();
                // stack.pop();
                int index = stack.pop();
                results[index] = i - index;
            }
            stack.push(i);
        }

        return results;
    }
}
