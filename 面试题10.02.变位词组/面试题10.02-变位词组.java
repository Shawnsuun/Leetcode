class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            map.putIfAbsent(sortedStr, new LinkedList<String>());
            map.get(sortedStr).add(str);
        }
        List<List<String>> res = new LinkedList<List<String>>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}