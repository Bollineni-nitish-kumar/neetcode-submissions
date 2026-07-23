class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> tCharFreq = new HashMap<>();
        Map<Character,Integer> sCharFreq = new HashMap<>();

        if(t.length() > s.length()){
            return "";
        }

        for(char ch : t.toCharArray()){
            tCharFreq.put(ch,tCharFreq.getOrDefault(ch,0)+1);
        }

        String minWindow = "";
        int start =0;
        
        for(int ind = 0; ind < s.length();ind++){
            char ch = s.charAt(ind);
            sCharFreq.put(ch,sCharFreq.getOrDefault(ch,0)+1);

            if(!isValidSubString(tCharFreq,sCharFreq)){
                continue;
            }else{
                while(start <= ind){
                    char startChar = s.charAt(start);
                    sCharFreq.put(startChar,sCharFreq.get(startChar)-1);
                    if(isValidSubString(tCharFreq,sCharFreq)){
                        start++;       
                        continue;
                    }else{
                        sCharFreq.put(startChar,sCharFreq.get(startChar)+1);

                        break;
                    }
                }
                if(minWindow == "" || s.substring(start,ind+1).length() < minWindow.length()){
                    minWindow = s.substring(start,ind+1);
                }
            }

        }

        return minWindow;

        
    }

    private boolean isValidSubString(Map<Character,Integer> tCharFreq,Map<Character,Integer> sCharFreq){
        for(Character ch : tCharFreq.keySet()){
            int chFreq = tCharFreq.get(ch);
            if(!sCharFreq.containsKey(ch)){
                return false;
            }else{
               if(sCharFreq.get(ch) < chFreq){
                   return false;
               }
            }
        }
        return true;
    }
}
