class Solution {
    public boolean isPalindrome(String s) {
        String[] wordsArr = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for(String word : wordsArr){
            String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            sb.append(cleanedWord);
        }
        String onlyalphaNumChars = sb.toString();

        int start = 0;
        int end = onlyalphaNumChars.length()-1;

        while(start <= end){
            if(onlyalphaNumChars.charAt(start) != onlyalphaNumChars.charAt(end)){
                System.out.println(start);
                System.out.println(onlyalphaNumChars.charAt(start));
                System.out.println(end);
                System.out.println(onlyalphaNumChars.charAt(end));
                return false;
            }
            start++;
            end--;
        }

        return true;
        
    }
}
