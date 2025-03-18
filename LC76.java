// https://leetcode.com/problems/minimum-window-substring/description/
class Solution {
    public String minWindow(String s, String t) {
        int[] map=new int[128];
        for(int i=0;i<t.length();i++)map[t.charAt(i)]++;
        int count=t.length();
        int start=0,end=0,minLen=Integer.MAX_VALUE,i=0;
        while(end<s.length()){
            if(map[s.charAt(end++)]-->0) count--;
            while(count==0){
                if(end-start<minLen){
                    minLen=end-start;
                    i=start;
                }
                if(map[s.charAt(start++)]++==0)count++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(i,i+minLen);
    }
}
