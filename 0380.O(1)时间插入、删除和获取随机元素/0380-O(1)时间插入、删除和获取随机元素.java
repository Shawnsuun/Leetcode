class RandomizedSet {
    HashMap<Integer, Integer> numLocations;
    ArrayList<Integer> nums;
    Random ran;
    
    public RandomizedSet() {
        numLocations = new HashMap<>();
        nums = new ArrayList<>();
        ran = new Random();
    }
    
    public boolean insert(int val) {
        if (numLocations.containsKey(val)) {
            return false;
        }
        numLocations.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!numLocations.containsKey(val)) {
            return false;
        }
        
        int deleteLocation = numLocations.get(val);
        int lastLocation = nums.size() - 1;
        int lastNum = nums.get(lastLocation);

        nums.set(deleteLocation, lastNum);
        nums.remove(lastLocation);

        numLocations.put(lastNum, deleteLocation);
        numLocations.remove(val);

        return true;
    }
    
    public int getRandom() {
        int ranNum = ran.nextInt(nums.size());
        return nums.get(ranNum);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */