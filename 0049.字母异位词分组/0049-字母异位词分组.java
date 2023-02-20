class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chArray= str.toCharArray();
            Arrays.sort(chArray);
            String sorted = new String(chArray);
            groups.putIfAbsent(sorted, new ArrayList());
            groups.get(sorted).add(str);
        }
        return new ArrayList(groups.values());
    }
}