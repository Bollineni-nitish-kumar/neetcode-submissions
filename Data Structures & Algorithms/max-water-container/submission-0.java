class Solution {
    public int maxArea(int[] heights) {

        int s=0,e=heights.length-1;

        int maxWater = Integer.MIN_VALUE;

        while(s < e){
            int width  = e-s;
            int len = Math.min(heights[s],heights[e]);
            int area = len*width;

            maxWater = Math.max(maxWater,area);

            if(heights[s] >= heights[e]){
                e--;
            }else{
                s++;
            }
        }

        return maxWater;
        
    }
}
