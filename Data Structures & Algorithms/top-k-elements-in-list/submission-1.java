class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numVsFreq = new HashMap<>();

        for(int num : nums){
            numVsFreq.put(num,numVsFreq.getOrDefault(num,0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];

        for(Map.Entry<Integer,Integer> entry : numVsFreq.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            if(buckets[freq]==null){
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int ind =0;

        for(int i=nums.length; i >=0 ; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    if(ind == k){
                       return result;
                    }
                    result[ind++]=num;
                }
            }
            if(ind == k){
                return result;
            }
        }

        return result;
        
    }
}
