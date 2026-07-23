class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }

        Set<Integer> uniqueNums = new HashSet<>();
        for(int num : nums){
            uniqueNums.add(num);
        }

        int ans = 0;

        for(int num  : uniqueNums){
            if(!uniqueNums.contains(num-1)){
                int currNum = num;
                int currSeq =1;

                while(uniqueNums.contains(currNum+1)){
                    currNum = currNum+1;
                    currSeq++;
                }

                ans= Math.max(ans,currSeq);
            }
        }

        return ans;
        
    }
}
