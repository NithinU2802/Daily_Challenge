/******************************************************************************

    To check subarray sum which is divsible by k (Rough Work)

*******************************************************************************/

public class checkSubarraySum
{
    
    public static boolean checkSubarraySum(int[] nums, int k) {
        long[] dp=new long[nums.length];
        dp[0]=nums[0];
        System.out.print(nums[0]+" ");
        for(int i=1;i<nums.length;i++){
            dp[i]=dp[i-1]+nums[i];
            if(dp[i]%k==0)
                return true;
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+2;j<nums.length;j++){
                if(Math.abs(dp[i]-dp[j])%k==0)
                    return true;
                System.out.print(Math.abs(dp[i]-dp[j])+" ");
            }
            System.out.println();
        }
        return false;
    }
    
	public static void main(String[] args) {
		int[] a=new int[]{2,4,6};
	    System.out.println(checkSubarraySum(a,6));
	}
}
