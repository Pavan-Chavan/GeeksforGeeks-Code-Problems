//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        HashMap<Character, Integer> mpp = new HashMap<Character, Integer> ();
        int len = S.length(), right=0,left=0,maxlen=0;
        if(len==0) return 0;
        while(right<len) {
            if(mpp.containsKey(S.charAt(right)))
                left = Math.max(left, mpp.get(S.charAt(right))+1); // reconsider
            mpp.put(S.charAt(right),right);
            maxlen = Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}