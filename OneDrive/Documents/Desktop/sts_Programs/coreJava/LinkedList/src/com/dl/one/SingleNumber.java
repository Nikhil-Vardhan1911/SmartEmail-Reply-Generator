package com.dl.one;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
		
		int result = 0;
		for(int i=0;i<nums.length;i++) {
			result = result^nums[i];
		}
		return result;
	}
	public static void main(String[] args) {
		
		int nums[]= {2,2,1};
		SingleNumber obj = new SingleNumber();
		int outcome = obj.singleNumber(nums);
		
		System.out.println(outcome);
	}
}