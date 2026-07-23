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
        Set<Pair> uniquePairs = new HashSet<>();
        int start = 0;
        for(int ind=0; ind<s.length(); ind++){
            Pair p = new Pair(s.charAt(ind),ind);
            if(!uniquePairs.contains(p)){
                uniquePairs.add(p);
            }else{
                maxLen = Math.max(maxLen,uniquePairs.size());
                Pair ep = null;
                for(Pair present : uniquePairs){
                    if(present.equals(p)){
                        ep = present;
                        break;
                    }
                }
                int index = ep.index;

                for(int i=start;i<=index ;i++){
                    uniquePairs.remove(new Pair(s.charAt(i)));
                }
                uniquePairs.add(p);
                start = index+1;

            }
        }
        maxLen=Math.max(maxLen,s.length()-start);

        return maxLen;
        
    }
}
