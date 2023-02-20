class Solution {
    char[] num;     //chars of num to be printed
    int index;      //index of res array
    int[] res;      //res to be returned

    public int[] printNumbers(int n) {
        num = new char[n];
        index = 0;
        res = new int[(int)(Math.pow(10, n) - 1)];
        dfs(0, n);
        return res;
    }

    private void dfs(int i, int n) {
        if (i == n) {
            int curNum = Integer.parseInt(String.valueOf(num));
            if (curNum != 0) {
                res[index ++] = curNum;
            }
            return;
        }
        for (char ch = '0'; ch <= '9'; ch ++) {
            num[i] = ch;
            dfs(i + 1, n);
        }
    }
}