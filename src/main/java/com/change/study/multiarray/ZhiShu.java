package com.change.study.multiarray;

import java.util.LinkedList;
import java.util.List;

public class ZhiShu {

	public static void main(String[] args) {
//		int[] arr = {3,1,15,2,6,11,7};
//		BubbleSort1(arr);
//		for(int a:arr){
//			System.out.println(a);
//		}
//		int[] arr = {1,1,1,2,6,7};
//		delDuplicate(arr);
//		for(int a:arr){
//			System.out.println(a);
//		}
//		int[] arr = {1,2,3,4,5,6,7};
//		rotateArr2(arr, 3);
//		for(int a:arr){
//			System.out.print(a);
//		}
		int[] arr = {1,1,3,4,4,7,7};
		singleNum(arr);
	}
	
	/**
	 * 0跟任何一个正整数n异或后，都还是会得到n自己
	 * n自己再跟n自己异或后，都还是会得到0
	 * 如果都是重复出现的数字，理论上，最后得到的还会是0
	 * 所以，只要有单独的数字，那么异或一次后，一定会得到这个单独的数字
	 */
	public static void singleNum(int[] nums) {
		int res = 0;        
		for (int num : nums){
			res =res ^ num;
		}         
		System.out.println(res);
	}
	
	public static void rotateArr2(int[] nums,int k) {
		int len = nums.length;
	    if(len<=1){
	    	return;
	    } 
	    int[] a = new int[len];
	    for(int i =0 ; i<len ; i++){
	        a[i] = nums[i];
	    }
	    k = k%len; //去重
	    for(int i = 0 ; i<len ; i++){
	        int s = k+i;
	        s = s %len;
	        nums[s] = a[i];
	    }
	}
	
	public static void rotateArr(int[] arr,int k) {
		List<Integer> aList = new LinkedList<Integer>();
		for(int a:arr){
			aList.add(a);
		}
		for(int i=0;i<k;i++){
			int lastEleIndex = aList.size()-1;
			int lastEle = aList.get(lastEleIndex);
			aList.remove(lastEleIndex);
			aList.add(0,lastEle);
		}
		System.out.println(aList.toString());
	}
	
	public static void delDuplicate(int[] arr) {
		int i=1;
		int j=1;
		int size = arr.length;
		while(j<size){
			if(arr[j]==arr[i-1]){
				j += 1;
			}else{
				arr[i] = arr[j];
				j += 1;
				i += 1;
			}
		}
		System.out.println(size>i?i:size);
	}
	
	public static void BubbleSort1(int[] arr){
		   int temp;//临时变量
		   boolean flag;//是否交换的标志
		   for(int i=0; i<arr.length-1; i++){   //表示趟数，一共arr.length-1次。
		       flag = false;
		       for(int j=arr.length-1; j>i; j--){
		    	   int a = arr[j];
		    	   int b = arr[j-1];
		           if(arr[j] < arr[j-1]){
		               temp = arr[j];
		               arr[j] = arr[j-1];
		               arr[j-1] = temp;
		               flag = true;
		           }
		       }
		       if(!flag){
		    	   break;  
		       } 
		   }
		}

	public static void testPrime() {
		for(int i=100;i<200;i++){
			boolean isPrime = true;
			for(int j=2;j<i;j++){
				if(i % j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				System.out.println(i);
			}
		}
	}
}
