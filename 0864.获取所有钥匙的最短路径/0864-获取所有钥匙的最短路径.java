class Solution {
    public int shortestPathAllKeys(String[] grid) {
        //Initialize, K: number of keys, INF: infinite num
        int K = 6, INF = 0x3f3f3f3f;
        //four directions
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        //row, col is the map size, key is the count of keys
        int row = grid.length;
        int col = grid[0].length();
        int keys = 0;
        //dists is the minimum steps to get to (n, m) in state K, 2 power K possibilities
        int[][][] dists = new int[row][col][1 << K];
        //queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        //find start point, calculate key numbers
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                Arrays.fill(dists[i][j], INF);
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    queue.add(new int[] {i, j, 0});
                    dists[i][j][0] = 0;
                } else if (ch >= 'a' && ch <= 'z') {
                    keys ++;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int dist = dists[pos[0]][pos[1]][pos[2]];
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                //if out of bound, skip to next
                if (r < 0 || r >= row || c < 0 || c >= col) continue;
                //get the char in the next direction to decide next step
                char ch = grid[r].charAt(c);
                //meet the wall, iterate next
                if (ch == '#') continue;
                //meet a lock and don't have a key, skip to next
                if ((ch >= 'A' && ch <= 'Z') && ((pos[2] >> ch - 'A') & 1) == 0) continue; 
                int state = pos[2];
                //meet a key, update the state
                if ((ch >= 'a' && ch <= 'z')) state |= 1 << (ch - 'a');
                //all the keys are aquired, return result
                if (state == (1 << keys) - 1) return dist + 1;
                //if there is shorter path updated before, skip to next
                if (dist + 1 >= dists[r][c][state]) continue;
                dists[r][c][state] = dist + 1;
                queue.add(new int[] {r, c, state});
            }
        }
        return -1;
    }
}