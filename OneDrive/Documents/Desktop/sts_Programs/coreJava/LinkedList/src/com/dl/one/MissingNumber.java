package com.dl.one;

public class MissingNumber {
	
	public int missingNumber(int[] nums) {
		
		int n = nums.length;
		boolean[] seen = new boolean[n+1];
		
		for(int num:nums) {
			seen[num] = true;
		}
		
		for(int i=0;i<nums.length;i++) {
			if(!seen[i]) {
				return i;
			}
		}
		return n;
	}
}
