package com.change.study.multiarray;

/**
 * 
 * 代码需求： 对等行等列的二维数组进行 行列 的互换
 * 
 * 分析过程 主对角线是保持不变 行列互换即角标互换：[0][1] => [1][0] 循环次数：外层循环行，内层循环每一行的列
 */
public class MultiArraysReverse {

	public static void main(String[] args) {
		int[][] mArr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("before reverse:");
		printMultiArray(mArr);
//		System.out.println("after reverse:");
//		reverseMultiArr(mArr);
//		printMultiArray(mArr);
		reversMultiArr2(mArr);
	}

	public static void reverseMultiArr(int[][] mArr) {
		int reverCount = 0;
		for (int i = 0; i < mArr.length - 1; i++) {
			// 列循环从：i+1开始，提高循环效率
			for (int j = i + 1; j < mArr[i].length; j++) {
				System.out.println(i + "_" + j + " rev : ij_value :" + mArr[i][j] + " ,ji_value:" + mArr[j][i]);
				int temp = mArr[i][j];
				mArr[i][j] = mArr[j][i];
				mArr[j][i] = temp;
				reverCount += 1;
			}
		}
		System.out.println("reverse count :" + reverCount);
	}

	public static void reversMultiArr2(int[][] mArr) {
		int arr2[][]=new int[mArr.length][mArr.length];
		for(int i=0;i<mArr.length;i++){
			for(int j=0;j<mArr[i].length;j++){
				arr2[i][j] = mArr[j][i];
			}
		}
		System.out.println("after reverse:");
		printMultiArray(arr2);
	}

	public static void printMultiArray(int[][] mArr) {
		for (int i = 0; i < mArr.length; i++) {
			for (int j = 0; j < mArr[i].length; j++) {
				System.out.print(mArr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
