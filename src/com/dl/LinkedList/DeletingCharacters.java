package com.dl.LinkedList;

import java.util.Arrays;

public class DeletingCharacters {

	public static void main(String[] args) {
		
		int nums[] = {1,2,-1,-2,1,0,-1};
		
		// -2,-1,-1,0,1,1,2,
		Arrays.sort(nums);
		int j = 0;
		
		int sum = 0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]==nums[j]) {
				sum+=nums[i];
			}
			if(nums[i]!=nums[j]) {
				sum+=nums[i];
			}
			j++;
		}
		System.out.println(sum);
	}
}