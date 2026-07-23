class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numWithSmallestIndex = new HashMap<>();

        numWithSmallestIndex.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            int otherNum = target - nums[i];
            if(numWithSmallestIndex.containsKey(otherNum)){
                return new int[]{numWithSmallestIndex.get(otherNum),i};
            }else{
                numWithSmallestIndex.putIfAbsent(nums[i],i);
            }
        }
        return new int[2];
    }
}
