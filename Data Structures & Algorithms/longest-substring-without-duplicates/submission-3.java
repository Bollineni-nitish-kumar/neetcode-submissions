class Pair{
    Character ch;
    int index;

    public Pair(Character ch,int index){
        this.ch = ch;
        this.index = index;
    }

    public Pair(Character ch){
        this.ch = ch;
    }

    public boolean equals(Object other){
        Pair otherP = (Pair)other;
        if(this.ch == otherP.ch){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return (int)ch;
    }

     @Override
    public String toString() {
        return "ElementInfo[character=" + this.ch + ", index=" + this.index + "]";
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character,Integer> charVsLatestIndex = new HashMap<>();
        int start = 0;
        for(int ind=0; ind<s.length(); ind++){
            char ch = s.charAt(ind);
            if(charVsLatestIndex.containsKey(ch)){
                start = Math.max(start,charVsLatestIndex.get(ch)+1);
            }
            charVsLatestIndex.put(ch,ind);
            maxLen = Math.max(maxLen,ind-start+1);
        }

        return maxLen;
        
    }
}
