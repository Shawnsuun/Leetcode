class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidgroup = new Stack<Integer>();
        for (int asteroid : asteroids) {
            //Collision(s) exist, pop all the explode asteroid.
            while (!asteroidgroup.empty() && asteroidgroup.peek() + asteroid < 0 
            && asteroidgroup.peek() > 0) {
                    asteroidgroup.pop();
            }
            //Both asteroid explode, end collision.
            if (!asteroidgroup.empty() && asteroidgroup.peek() + asteroid == 0 && asteroid < 0) {
                asteroidgroup.pop();
            } 
            //Conditions of no collisions. 
            else if (asteroidgroup.empty() || asteroidgroup.peek() < 0 || asteroid > 0) {
                asteroidgroup.push(asteroid);
            }                                  
        }
        return asteroidgroup.stream().mapToInt(i->i).toArray();
    }
}