class Solution {
    public String shortestPalindrome(String s) {
        int n=s.length();
        int i=0,j=n-1;
        while(j>=0){
            while(j>=0&&s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            j--;
        }
        if(i==n)return s;
        String sub = s.substring(i);
        String r=(new StringBuilder(sub).reverse()).toString();
        return r+shortestPalindrome(s.substring(0,i))+sub;

    }
}
