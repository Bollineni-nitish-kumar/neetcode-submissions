class Solution {
    public int findMin(int[] nums) {
        int minEle = Integer.MAX_VALUE;

        int start=0,end=nums.length-1;
        while(start <=end){
            int mid = start+(end-start)/2;
            minEle = Math.min(minEle,nums[mid]);

            if(nums[mid] < nums[end]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return minEle;
         
        
    }
}
