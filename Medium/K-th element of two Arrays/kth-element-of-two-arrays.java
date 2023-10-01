//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        int n1 = arr1.length, n2 = arr2.length;
        int cnt=1;
        long cntEle = 0;
        int i=0, j=0;
        while(i<n1 && j<n2) {
            if(arr1[i] < arr2[j]) {
                if(k == cnt) cntEle=arr1[i];
                cnt++;
                i++;
            } else {
                if(k == cnt) cntEle=arr2[j];
                cnt++;
                j++;
            }
        }
        while(i<n1) {
            if(k == cnt) cntEle=arr1[i];
            cnt++;
            i++;
        }
        while(j<n2) {
            if(k == cnt) cntEle=arr2[j];
            cnt++;
            j++;
        }
        return cntEle;
    }
}