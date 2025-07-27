package com.dl.LinkedList;

import java.util.Arrays;

public class UniqueSubArrayElements {

	 public int maxSum(int[] nums) {

	       Arrays.sort(nums);
	        int sum = nums[nums.length - 1], prev = sum;
	        for (int i = nums.length - 2; i >= 0 && nums[i] >= 0; prev = nums[i], i--)
	            if (nums[i] != prev)
	                sum += nums[i];
	        return sum;
	    }
	 
   public static void main(String[] args) {
	   
	   int nums[] = {1,2,3,4,5};
	   
	   UniqueSubArrayElements obj = new UniqueSubArrayElements();
	   int result = obj.maxSum(nums);
	   System.out.println(result);
   }
}
