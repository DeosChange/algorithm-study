package com.change.study.hannuo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A桌子上从上往下是从小往大放着panelNum个盘子:1 2 3 4 5 ...
 * B桌子
 * C桌子
 * 要求：一次只能移到一个盘子且大盘子永远不能在小盘子上面
 * 最终效果:将A上的盘子全部移到C上
 * 
 * 思路：
 * 1、当A上只有1个盘子时，直接从A移到C即可；
 *   步骤：A->C
 * 2、当A上有2个盘子时，则先将第n-1个盘子从A放到B上，再将第n个盘子从A放到C上，再将第n-1个盘子从B放到C上；
 *   步骤：A->B A->C B->C
 * 3、当A上有3个盘子时，
 */
public class StudyHanNuo {
	static Integer calcuCount = 0;
	static Integer maxNum = 0;
	public static void main(String[] args) {
		Integer testNum = 4;
		maxNum = testNum;
		testHanNuo2(testNum);
//		testhanNuo(testNum);
	}
	
	//概念性实现
	public static void testHanNuo2(Integer panelNum){
		hanNuo2(panelNum,"A","B","C");
	}
	
	public static void hanNuo2(Integer panelNum,String fromPanel,String tempPanel,String toPanel){
		if(1 == Integer.valueOf(panelNum)){
			move2(panelNum, fromPanel, toPanel);
		}else if(1 < Integer.valueOf(panelNum)){
			hanNuo2((panelNum-1), fromPanel,toPanel,tempPanel);
			move2(panelNum, fromPanel,toPanel);
			hanNuo2((panelNum-1), tempPanel,fromPanel,toPanel);
		}
	}
	
	public static void move2(Integer panelTag,String fromPanel,String toPanel){
		String pTag = "n";
		if(Integer.valueOf(maxNum) != Integer.valueOf(panelTag)){
			pTag = pTag + "-" + (maxNum - panelTag);
		}
		System.out.println("step-"+(++calcuCount)+" : move "+pTag+" from "+fromPanel+" to "+toPanel);
	}
	
	//list应用
	public static void testhanNuo(Integer panelNum){
		//A桌子上从上往下是从小往大放着panelNum个盘子：1、2、3、4、5、6、7、8、9...
		List<Integer> desk_a = new LinkedList<Integer>();
		for(int i=1;i<(panelNum+1);i++){
			desk_a.add(i);
		}
		List<Integer> desk_b = new LinkedList<Integer>();
		List<Integer> desk_c = new LinkedList<Integer>();
		Map<String, List<Integer>> deskAMap = new HashMap<String, List<Integer>>();
		Map<String, List<Integer>> deskBMap = new HashMap<String, List<Integer>>();
		Map<String, List<Integer>> deskCMap = new HashMap<String, List<Integer>>();
		deskAMap.put("desk_a", desk_a);
		deskBMap.put("desk_b", desk_b);
		deskCMap.put("desk_c", desk_c);
		System.out.println("desk_a : "+desk_a.toString());
		hanNuo(panelNum,deskAMap,deskBMap,deskCMap);
		System.out.println("desk_a : "+deskAMap.get("desk_a").toString());
		System.out.println("desk_b : "+deskBMap.get("desk_b").toString());
		System.out.println("desk_c : "+deskCMap.get("desk_c").toString());
	}
	
	public static void hanNuo(Integer panelNum,Map<String, List<Integer>> deskAMap,Map<String, List<Integer>> deskBMap,Map<String, List<Integer>> deskCMap) {
		if(1 == Integer.valueOf(panelNum)){
			move(panelNum, deskAMap,deskCMap);
		}else if(1 < Integer.valueOf(panelNum)){
			hanNuo((panelNum-1), deskAMap,deskCMap,deskBMap);
			move(panelNum, deskAMap,deskCMap);
			hanNuo((panelNum-1), deskBMap,deskAMap,deskCMap);
		}
	}
	
	public static void move(Integer panelTag,Map<String, List<Integer>> fromDeskMap,Map<String, List<Integer>> toDeskMap){
		String fromDeskName = "";
		List<Integer> fromDesk = null;
		for(String key : fromDeskMap.keySet()){
			fromDeskName = key;
			fromDesk = fromDeskMap.get(key);
		}
		String toDeskName = "";
		List<Integer> toDesk = null;
		for(String key : toDeskMap.keySet()){
			toDeskName = key;
			toDesk = toDeskMap.get(key);
		}
		System.out.println("step-"+(++calcuCount)+" : panelTag = "+panelTag+" from "+fromDeskName+" to "+toDeskName);
		Integer moveEle = fromDesk.get(0);
//		System.out.println("moveEle : "+moveEle);
		fromDesk.remove(0);
		toDesk.add(0,moveEle);
	}
}
