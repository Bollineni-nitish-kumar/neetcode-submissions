class Solution {
    public boolean isAnagram(String s, String t) {

        int[] charFreq = new int[26];

        for(Character ch  : s.toCharArray()){
            charFreq[ch-'a']++;
        }

        for(Character ch : t.toCharArray()){
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
