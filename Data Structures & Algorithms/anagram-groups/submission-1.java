class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Set<Integer> alreadyTaken = new HashSet<>();

        for(int ind = 0 ; ind < strs.length;ind++){
            if(alreadyTaken.contains(ind)){
                continue;
            }

            alreadyTaken.add(ind);
            List<String> group = new ArrayList<>();
            group.add(strs[ind]);
            ans.add(group);

            for(int jnd=ind+1;jnd < strs.length;jnd++){
                if(alreadyTaken.contains(jnd)){
                    continue;
                }

                Boolean isAnagrams = this.isAnagrams(strs[ind],strs[jnd]);
                if(isAnagrams){
                    group.add(strs[jnd]);
                    alreadyTaken.add(jnd);
                }
            }
        }

        return ans;      
    }

    private Boolean isAnagrams(String str1,String str2){
        int[] charFreq = new int[26];

        for(Character ch  : str1.toCharArray()){
            charFreq[ch-'a']++;
        }

         for(Character ch  : str2.toCharArray()){
            charFreq[ch-'a']--;
        }

        for(int freq : charFreq){
            if(freq !=0){
                return false;
            }
        }
        return true;
    }
}
