class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String token : tokens){
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)){
                int temp = 0;
                int j = Integer.parseInt(stack.pop());
                int i = Integer.parseInt(stack.pop());
                switch(token){
                    case "+":
                        temp = i+j;
                        break;
                    case "-":
                        temp = i-j;
                        break;
                    case "*":
                        temp = i*j;
                        break;
                    case "/":
                        temp = i/j; 
                        break;   
                }
                stack.push(String.valueOf(temp));
            }else{
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
