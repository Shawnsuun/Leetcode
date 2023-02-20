class Solution {
    private int res;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = Arrays.stream(baseCosts).min().getAsInt();    //res = minbase if target > anybase
        for (int base : baseCosts) {    //traverse all base
            dfs(toppingCosts, 0, base, target);
        }
        return res;
    }

    private void dfs(int[] toppingCosts, int p, int curCost, int target) {
        if (Math.abs(res - target) < curCost - target) {
            return;
        } else if (Math.abs(res - target) >= Math.abs(curCost - target)) {
            if (Math.abs(res - target) > Math.abs(curCost - target)) {
                res = curCost;  //find closer cost, update res
            } else {
                res = Math.min(res, curCost);   //get lower one of possible multiple res.
            }
        }

        if (p == toppingCosts.length) {
            return;
        }
        dfs(toppingCosts, p + 1, curCost + toppingCosts[p] * 2, target);    //2 serves p tooping
        dfs(toppingCosts, p + 1, curCost + toppingCosts[p], target);    //1 serve p topping
        dfs(toppingCosts, p + 1, curCost, target);  //no p topping
    }
}