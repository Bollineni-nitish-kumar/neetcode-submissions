class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int lenStr = 0;
        while(lenStr < str.length()){
            int indOfHash = str.indexOf("#",lenStr);
            String wordLenStr = str.substring(lenStr,indOfHash);
            Integer wordLen = Integer.parseInt(wordLenStr);
            String actual = str.substring(indOfHash+1,indOfHash+1+wordLen);
            ans.add(actual);
            lenStr = indOfHash+1+wordLen;

        }
        return ans;

    }
}
