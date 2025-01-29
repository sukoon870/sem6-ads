public class PalindromeAlphaNumeric {
    public static void main(String[] args) {
        System.out.println(check("A man, a plan, a canal: Panama")); 
    }
    public static boolean check(String str){
        str=str.toLowerCase();
        int l=0,r=str.length()-1;
        while(l<r){
            while(l<r&&!Character.isLetterOrDigit(str.charAt(l)))l++;
            while(l<r&&!Character.isLetterOrDigit(str.charAt(r)))r--;
            if(str.charAt(l)!=str.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
}
