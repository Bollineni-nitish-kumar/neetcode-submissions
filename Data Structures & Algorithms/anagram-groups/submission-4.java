class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> group = new HashMap<>();

        for(int ind = 0 ; ind < strs.length;ind++){
            String str = getCharFreqOfAllCharsAsString(strs[ind]);
            if(group.containsKey(str)){
                group.get(str).add(strs[ind]);
            }else{
                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[ind]);
                group.put(str,anagrams);
            }
        }

        return new ArrayList<>(group.values());      
    }

    private String getCharFreqOfAllCharsAsString(String str1){
        int[] charFreq = new int[26];

        for(Character ch  : str1.toCharArray()){
            charFreq[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder("");
        for(int freq : charFreq){
            sb.append(freq+"#");
        }
        return sb.toString();
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
