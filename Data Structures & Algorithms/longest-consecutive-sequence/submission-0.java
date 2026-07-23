class Solution {
    public int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        int ans = -1;

        int currSeqLen = 0;

        for(int ind =0; ind < nums.length;ind++){
            currSeqLen++;
            if(ind+1 < nums.length && nums[ind] == nums[ind+1]){
                currSeqLen--;
                continue;
            }
            if(ind+1 < nums.length && nums[ind]+1 != nums[ind+1]){
                ans = Math.max(ans,currSeqLen);
                currSeqLen = 0;
                continue;
            }

        }
        ans = Math.max(ans,currSeqLen);

        return ans;


        
    }
}
