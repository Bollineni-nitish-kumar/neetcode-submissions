class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrLen = nums.length;
        int[] ans = new int[arrLen];
        int numOfZeros = 0;
        int productExceptZeros = 1;

        for(int num : nums){
            if(num == 0){
                numOfZeros++;
                continue;
            }

            productExceptZeros = productExceptZeros*num;
        }

        if(numOfZeros > 1){
            return ans;
        }

        if(numOfZeros == 1){
            for(int ind =0 ;ind < arrLen;ind++){
                if(nums[ind] == 0){
                    ans[ind]=productExceptZeros;
                }
            }
        }else{
            for(int ind =0 ;ind < arrLen;ind++){
                ans[ind]=productExceptZeros/nums[ind];
            }
        }

        return ans;
    }
}  
