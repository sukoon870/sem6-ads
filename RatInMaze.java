import java.util.*;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] arr = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 1, 1, 0, 0 },
                         { 0, 1, 1, 1 } };
        int n=arr.length;
        List<String> ans=new ArrayList<>();
        var sb=new StringBuilder();
        solve(arr,n,ans,sb,0,0);
        System.out.println(ans);
    }
    public static void solve(int[][] arr,int n,List<String> ans,StringBuilder sb,int r,int c){
        if(r>=n||c>=n||r<0||c<0)return;
        if(arr[r][c]==0)return;
        if(r==n-1&&c==n-1){
            ans.add(sb.toString());
            return;
        }
        arr[r][c]=0;
        sb.append('D');
        solve(arr,n,ans,sb,r+1,c);
        sb.deleteCharAt(sb.length()-1);

        sb.append('T');
        solve(arr,n,ans,sb,r-1,c);
        sb.deleteCharAt(sb.length()-1);
        
        sb.append('R');
        solve(arr,n,ans,sb,r,c+1);
        sb.deleteCharAt(sb.length()-1);
        
        sb.append('L');
        solve(arr,n,ans,sb,r,c-1);
        sb.deleteCharAt(sb.length()-1);
        
        arr[r][c]=1;
    }
}
