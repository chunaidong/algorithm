package leecode;

import java.util.Stack;

public class _20_有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c =='[' || c =='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char c1 = stack.pop();
                if(c == ')' && c1 !='(' ) return false;
                if(c == ']' && c1 !='[' ) return false;
                if(c == '}' && c1 !='{' ) return false;
            }
        }
        return stack.isEmpty();
    }

}
