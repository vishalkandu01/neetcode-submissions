class Solution {
    public int calPoints(String[] operations) {
        // int n = operations.length;
        // List<Integer> list = new ArrayList<>();

        // for (int i = 0; i < n; i++) {
        //     if (operations[i].equals("+")) {
        //         int lastEle = list.get(list.size() - 1);
        //         int lastSecondEle = list.get(list.size() - 2);
        //         list.add(lastEle + lastSecondEle);
        //     } else if (operations[i].equals("C")) {
        //         list.remove(list.size() - 1);
        //     } else if (operations[i].equals("D")) {
        //         int lastEle = list.get(list.size() - 1);
        //         list.add(lastEle * 2);
        //     } else {
        //         list.add(Integer.parseInt(operations[i]));
        //     }
        // }

        // int res = 0;
        // for (int i = 0; i < list.size(); i++) {
        //     res += list.get(i);
        // }

        // return res;





        int n = operations.length;
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (operations[i].equals("+")) {
                int lastEle = list.get(list.size() - 1);
                int lastSecondEle = list.get(list.size() - 2);
                list.add(lastEle + lastSecondEle);
                sum += lastEle + lastSecondEle;
            } else if (operations[i].equals("C")) {
                int remove = list.remove(list.size() - 1);
                sum -= remove;
            } else if (operations[i].equals("D")) {
                int lastEle = list.get(list.size() - 1);
                list.add(lastEle * 2);
                sum += lastEle * 2;
            } else {
                list.add(Integer.parseInt(operations[i]));
                sum += Integer.parseInt(operations[i]);
            }
        }

        return sum;
    }
}