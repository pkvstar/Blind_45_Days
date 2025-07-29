import java.util.*;
public class one{
    public static void main(String[] args){
        //? Rain water trapping
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        // int ans = rainWater(height);
        int ans = rainWater_second_method_optimal(height);
        System.out.print(ans);
    }
    public static int rainWater(int[] height){
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int sum=0;
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        for(int i=height.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        for(int i=0;i<height.length;i++){
            sum = sum + Math.min(left[i],right[i])-height[i];
        }
        return sum;
    }
    public static int rainWater_second_method_optimal(int[] height){
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax){
                    leftMax = height[left];
                }
                else{
                    ans+=(leftMax-height[left]);
                }
                left++;
            }
            else{
                if(height[right]>=rightMax){
                    rightMax = height[right];
                }
                else{
                    ans+=(rightMax-height[right]);
                }
                right--;
            }
        }
        return ans;
    }
}