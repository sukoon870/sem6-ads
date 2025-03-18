import java.util.*;

public class LongestSubstringTwoDistinct {
    public static int length(String s){
        Map<Character, Integer> map = new HashMap<>();
        int l=0,max=0;
        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>2){
                char lc=s.charAt(l);
                map.put(lc,map.get(lc)-1);
                if(map.get(lc)==0)map.remove(lc);
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(length("eceba"));
        System.out.println(length("ccaabbb"));
    }
}
