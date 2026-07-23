class Solution {
    public boolean isValid(String s) {
        if(s.length() < 2){
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        int ind=0;

        while(ind < s.length()){
            char ch = s.charAt(ind);
            if(ch == '{' || ch=='[' || ch=='('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char peekChar =stack.peek();
                if((ch =='}' && peekChar!='{') ||(ch==']' && peekChar!='[') || (ch==')' && peekChar!='(') ){
                   return false;
                }
                stack.pop();
            }
            ind++;
        }
        if(!stack.isEmpty()){
            return false;
        }

        return true;
        
    }
}
