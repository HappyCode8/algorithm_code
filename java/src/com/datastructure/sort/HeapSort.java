package com.datastructure.sort;


import com.datastructure.sort.experiment.SortUtil;

public class HeapSort {
	SortUtil su=new SortUtil();
	//堆排序
	public void adjustHeap(int nums[],int i,int length){
		int temp=nums[i];
		for(int k=2*i+1;k<length;k=k*2+1){
			if(k+1<length&&nums[k]<nums[k+1]) {
				k++;
			}
			if(nums[k]>temp){
				nums[i]=nums[k];
				i=k;
				}else {
				break;
			}
		}
		nums[i]=temp;
	}
	public int[] heapSort(int nums[]){
		//调节成了一个堆
		for(int i=nums.length/2-1;i>=0;i--) {
			adjustHeap(nums, i, nums.length);
		}
		//每次把堆顶的数据换到最后，升序大顶堆，降序小顶堆
		for(int j=nums.length-1;j>0;j--){
			su.swap(nums, 0, j);
			adjustHeap(nums, 0, j);
		}
		return nums;	
	}
}
