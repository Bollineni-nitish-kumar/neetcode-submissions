class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numVsFreq = new HashMap<>();

        for(int num : nums){
            numVsFreq.put(num,numVsFreq.getOrDefault(num,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.freq-b.freq);
        for(Map.Entry<Integer,Integer> entry : numVsFreq.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            pq.add(new Pair(num,freq));
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int currPos = 0;
        while(!pq.isEmpty()){
            ans[currPos++] = pq.poll().num;          
        }

        return ans;
        
    }

    static class Pair{
        int num;
        int freq;

        Pair(int num,int freq){
            this.num = num;
            this.freq = freq;
        }
    }
}
