class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && isPair(stack.peek(),c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    private boolean isPair(char c1, char c2){
        if(c1=='[') return c2==']';
        if(c1=='{') return c2=='}';
        if(c1=='(') return c2==')';
        return false;
    }
}
