class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numsLen = nums.length;

        int[] prefixProductArr = new int[numsLen];
        prefixProductArr[0] = 1;
         int prefixProduct = nums[0];

        for(int ind=1;ind < numsLen;ind++){
           prefixProductArr[ind] = prefixProduct;
           prefixProduct = prefixProduct * nums[ind];
        }

        int[] suffixProductArr = new int[numsLen];
        suffixProductArr[numsLen-1] = 1;
         int suffixProduct = nums[numsLen-1];

        for(int ind = numsLen-2;ind >=0;ind--){
           suffixProductArr[ind] = suffixProduct;
           suffixProduct = suffixProduct * nums[ind];
        }

        int[] ans = new int[numsLen];

        for(int ind =0;ind < numsLen;ind++){
            ans[ind] = prefixProductArr[ind] * suffixProductArr[ind];
        }

        return ans;

        
    }
}  
