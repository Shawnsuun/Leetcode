class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;        
        for(int[] tower : towers) {
            maxX = Math.max(maxX, tower[0]);
            maxY = Math.max(maxY, tower[1]);   
            minX = Math.min(minX, tower[0]);
            minY = Math.min(minY, tower[1]);   
        }
        
        int maxQ = 0; 
        int resX = 0;
        int resY = 0;
        for (int x = minX; x <= maxX; x ++) {
            for (int y = minY; y <= maxY; y ++) {
                int quantity = 0;
                for (int[] tower : towers) {
                    quantity += getQuantity(x, y, tower[0], tower[1], tower[2], radius);
                    if (quantity > maxQ) {
                        resX = x;
                        resY = y;
                        maxQ = quantity;
                    }
                }
            }
        }
        return new int[]{resX, resY};
    }

    private double getQuantity(int x, int y, int xi, int yi, int q, int radius) {
        double dis = Math.pow(x - xi, 2) + Math.pow(y - yi, 2);
        if (dis - radius *  radius > 0) {
            return 0;
        }
        double quantity = Math.floor(q / (1 + Math.sqrt(dis)));
        return quantity;
    }
}