//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public static String infixToPostfix(String exp) {
        Stack<Character>stk = new Stack<>();
        String result = new String("");
        
        for(int i=0; i<exp.length(); i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result += c;
            }
            else if(c=='('){
                stk.push(c);
            } 
            else if(c == ')') {
                while(!stk.empty() && stk.peek() != '(') {
                    result += stk.pop();
                }
                stk.pop();
            } else {
                while(!stk.empty() && Prec(c) <= Prec(stk.peek())) {
                    result += stk.pop();
                }
                stk.push(c);
            }
        }
        while(!stk.empty()) {
            if(stk.peek() == '(') 
                return "Invalid Expression";
            result += stk.pop();
        }
        return result;
    }
    static int Prec(char ch) {
        switch (ch) {
        case '+':
        case '-':
          return 1;
    
        case '*':
        case '/':
          return 2;
    
        case '^':
          return 3;
        }
        return -1;
    }
    
}