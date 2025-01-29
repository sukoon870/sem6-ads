// Your task for today is to solve the following problem:  

// Find the Closest Pair to Target (Medium)
// Given a sorted array, find two numbers whose sum is closest to but less than the target  

// Example:
// Input: arr = [1, 3, 5, 8, 10], target = 14
// Output: [5, 8] (because 5 + 8 = 13, which is the closest sum less than 14)  

// You are expected to utilize the two-pointer technique for this problem.

import java.util.*;
class Main {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        int target = Integer.parseInt(in.nextLine());
        int[] arr = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(twosum(arr,target)));
    }
    public static int[] twosum(int[] nums,int target){
        Arrays.sort(nums);
        int cl=Integer.MAX_VALUE;
        int[] ans = new int[2];
        int i=0,j=nums.length-1;
        while(i<j){
                int currsum = nums[i]+nums[j];
                if(Math.abs(target-currsum)<Math.abs(target-cl)){
                    cl=currsum;
                    ans[0]=nums[i];
                    ans[1]=nums[j];
                }
                if(currsum==target)return ans;
                if(currsum>target)j--;
                if(currsum<target)i++;
        }
        return ans;
    }
    
}
