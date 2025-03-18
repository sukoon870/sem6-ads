// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
import java.util.*;

public class LongestSubstringKUniques {
    public static int find(String s,int k) {
        Map<Character,Integer>map = new HashMap<>();
        int l=0,max=-1;
        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>k){
                char lc=s.charAt(l);
                int lcCount=map.get(lc)-1;
                map.put(lc,lcCount);
                if(lcCount==0)map.remove(lc);
                l++;
            }
            if(map.size()==k){
                max=Math.max(max,r-l+1);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String[] ss={
            "aabacbebebe","aaaa","aabaaab"
        };
        int[] kk = {3,2,2};
        for (int i = 0; i < 3; i++) {
            System.out.println(find(ss[i],kk[i]));
        }
    }
}
