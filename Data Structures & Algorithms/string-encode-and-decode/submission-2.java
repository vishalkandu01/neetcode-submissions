class Solution {

    public String encode(List<String> strs) {
        // String encodedString = "";
        // for (int i = 0; i < strs.size(); i++) {
        //     encodedString += strs.get(i) + "#";
        // }
        // return encodedString;


        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // List<String> decodedStringList = new ArrayList<>();
        // String decodedString = "";
        // for (int i = 0; i < str.length(); i++) {
        //     if(str.charAt(i) != '#') {
        //         decodedString += str.charAt(i);
        //     } else {
        //         decodedStringList.add(decodedString);
        //         decodedString = "";
        //     }
        // }
        // return decodedStringList;


        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            String s = str.substring(j + 1, j + 1 + len);
            res.add(s);
            i = j + 1 + len;
        }
        return res;
    }
}
