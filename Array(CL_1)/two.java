import java.util.*;
public class two{
    //? Product of an Array except itself
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] ans = productItself(nums);
        System.out.print(Arrays.toString(ans));
    }
    public static int[] productItself(int[] arr){
        int[] pro1 = new int[arr.length];
        int[] pro2 = new int[arr.length];
        pro1[0] = 1; 
        pro2[arr.length-1] = 1;
        for(int i=1;i<arr.length;i++){
            pro1[i] = pro1[i-1]*arr[i-1];
        }
        for(int i=arr.length-2;i>=0;i--){
            pro2[i] = pro2[i+1]*arr[i+1];
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = pro1[i]*pro2[i];
        }
        return arr;
    }
}