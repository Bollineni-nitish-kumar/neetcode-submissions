class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFreq = new int[26];
        int maxCharFreqInWindow = 0;
        int start =0;
        int maxLen = 0;

        for(int end=0;end<s.length();end++){
            charFreq[s.charAt(end)-'A']++;

            maxCharFreqInWindow = Math.max(maxCharFreqInWindow,charFreq[s.charAt(end)-'A']);

            int currWindowSize = end-start+1;
            if(currWindowSize-maxCharFreqInWindow > k){
                charFreq[s.charAt(start)-'A']--;
                start++;
            }

            maxLen = Math.max(maxLen,end-start+1);
        }

        return maxLen;

    }
}
