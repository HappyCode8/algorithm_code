package com.datastructure.sort;

import com.datastructure.sort.experiment.SortUtil;

public class ShellSort {
	SortUtil su=new SortUtil();
	//希尔排序
	public int[] shellSort(int nums[]){
		for(int gap=nums.length/2;gap>0;gap/=2){
			for(int i=gap;i<nums.length;i++){
				int j=i;
				while(j-gap>=0&&nums[j-gap]>nums[j]){
					su.swap(nums,j-gap,j);
					j-=gap;
				}
			}
		}
		return nums;	
	}
}
