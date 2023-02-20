class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        Set<String> forbid = new HashSet<String>(Arrays.asList(deadends));
        if (forbid.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        set1.add("0000");
        set2.add(target);
        int step = 1;
        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set1.size() > set2.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            Set<String> set3 = new HashSet<String>();
            for (String password : set1) {
                List<String> nextMoves = getNextMoves(password, forbid);
                for (String nextMove : nextMoves) {
                    if (set2.contains(nextMove)) {
                        return step;
                    }
                    if (!visited.contains(nextMove)) {
                        visited.add(nextMove);
                        set3.add(nextMove);
                    }
                }
            }
            set1 = set3;
            step ++;
        }
        return -1;
    }

    private List<String> getNextMoves(String password, Set<String> forbid) {
        List<String> nextMoves = new ArrayList<String>();
        char[] nums = password.toCharArray();
        for (int i = 0; i < nums.length; i ++) {
            char temp = nums[i];
            if (nums[i] >= '0' && nums[i] < '9') {
                nums[i] += 1;
            } else {
                nums[i] = '0';
            }
            if (!forbid.contains(new String(nums))) {
                nextMoves.add(new String(nums));
            }
            nums[i] = temp;
            if (nums[i] > '0' && nums[i] <= '9') {
                nums[i] -= 1;
            } else {
                nums[i] = '9';
            }
            if (!forbid.contains(new String(nums))) {
                nextMoves.add(new String(nums));
            }
            nums[i] = temp;            
        }
        return nextMoves;
    }
}