class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int carry=0;
        if(digits[n-1]==9){
            digits[n-1]=0;
            carry=1;
        }else digits[n-1]++;
        for(int i=n-2;i>=0;i--){
            int a=digits[i]+carry;
            digits[i]=a%10;
            carry=a/10;
        }
        if(carry==1){
            int[] arr=new int[n+1];
            arr[0]=1;
            for(int i=0;i<n;i++)arr[i+1]=digits[i];
            return arr;
        }
        return digits;
    }
}
