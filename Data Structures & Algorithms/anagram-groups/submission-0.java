class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        int len = strs.length;
        
        for (int i = 0; i < len; i++) {
            String str = strs[i];
            char[] sortedCharArray = str.toCharArray();
            Arrays.sort(sortedCharArray);
            String key = new String(sortedCharArray);
            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(key, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
