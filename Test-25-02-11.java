/*
 1. Find the Longest Subarray with Sum K (Prefix Sum / Two Pointers)
 Problem Statement:
 Given an array of integers nums and an integer k, find the length of the longest subarray that sums up to k.
 Example:
 Input: nums = [1, 2, 3, 1, 1, 1, 5, -1], k = 5  
Output: 4  
Explanation: The longest subarray with sum 5 is [2, 3] or [1, 1, 1, 2]

*/
import java.util.*;
class Test1{
    public static void main(String[] args){
        var in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=in.nextInt();
        System.out.println(longestSubArr(arr,k));
    }
    public static int longestSubArr(int[] arr,int k){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        map.put(0, -1);
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return maxLen;
    }
}

/*
 2. Minimum Window Substring (Sliding Window / Two Pointers)
 Problem Statement:
 Given two strings s and t, return the smallest substring of s that contains all characters of t. If no such substring exists, return ""
*/
class Test2{
    public static void main(String[] args){
        var in = new Scanner(System.in);
        String s1= in.nextLine();
        String s2= in.nextLine();
        System.out.println(minWindowSubstr(s1,s2));
    }
    public static String minWindowSubstr(String s1,String s2){
        int[] map = new int[128];
        for(int i=0;i<s2.length();i++)map[s2.charAt(i)]++;
        int start=0,end=0,minStart=0,minLen=Integer.MAX_VALUE,count=s2.length();
        while(end<s1.length()){
            if(map[s1.charAt(end)]-- > 0)count--;
            end++;
            while(count==0){
                if(end-start<minLen){
                    minLen=end-start;
                    minStart=start;
                }
                if(map[s1.charAt(start)]==0)count++;
                start++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s1.substring(minStart,minStart+minLen);
    }
}

/**

- 1. Frequency Arrays: Checking if Two Strings are Anagrams
	What is the time complexity of checking if two strings are anagrams using a frequency array? 
	B. O(n)
- 2. Prefix Sum: Finding Sum in a Given Range
 	Given an array arr[] of size n, what is the time complexity of finding the sum of elements from index l to r after building a prefix sum array?
	B. O(1)
- 3. Two Pointers: Finding Pairs that Sum to a Target
	 Which of the following approaches is the most efficient for finding two numbers that add up to a given target in a sortedarray?
	C. Two pointers
- 4. Sorting: Finding the Kth Smallest Element
	 Which sorting algorithm is best suited for finding the kth smallest element efficiently?
	B. quicksort
- In the Rabin-Karp algorithm for string matching, the time complexity in the worst case when all hash values collide is O(nm), while the average case time complexity is O(n+m)

 */