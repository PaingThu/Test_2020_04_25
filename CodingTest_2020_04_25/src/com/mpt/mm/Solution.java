
/*
 * 【2020年4月25日にサミットしたテクス１です。】
 * 
 * 下記の連続的な建物があります。その全ての建物をペイントしたいです。全ての建物をペイントする回数を計算してください。
 * |``| は　１階建物です。
 * 例：１
 *                         |``|
 *                         |``|    |``|
 *     |``|                |``||``||``||``|
 *     |``||``|    |``|    |``||``||``||``||``|
 * |``||``||``||``||``||``||``||``||``||``||``|
 *  1   3   2   1   2   1   5   3   3   4   2   階
 *  例：１の答えは「９」です。
 *  
 *  例：２
 *     |``|
 *     |``|
 *     |``|
 * |``||``|
 * |``||``|
 * |``||``|
 * |``||``|
 * |``||``|
 *  5   8   階
 *  例：２の答えは「８」です。
 */

package com.mpt.mm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// 入力データ【建物の階の配列】
		int[] A = {1,3,2,1,2,1,5,3,3,4,2};
		//出力データ【全ての建物をペイントする回数】
		int result = getAnswerTest1(A);
		
		System.out.println(result);
	}

	/**
	 * <pre>全ての建物をペイントする回数を出力する</pre>
	 * @param A[] 
	 * 		建物の階の配列
	 * @return　出力データー
	 */
	private static int getAnswerTest1(int[] tatemono) {
		
		//一番高い建物の階数を取得
		Integer max = Arrays.stream(tatemono).max().getAsInt();
		//一番低い建物の階数を取得
		Integer min = Arrays.stream(tatemono).min().getAsInt();
		
		//全部の建物で一番低い建物まで絶対ペイントしますので、低い建物までのペイントの回数を取得
		int numOfPaint = min;
		
		//一番低い建物上次の階から一番高い階までループしてペイントする回数を計算する
		for(int kai = min+1; kai <= max; kai++) { 
			List<String> tempPaint = new ArrayList<String>();
			 boolean paint = false;
			 int stop = 0;
			 for(int i = 0; i<tatemono.length;i++) {
				if(tatemono[i] >= kai) {
					paint = true;
				}else {
					paint = false;
					stop++;
				}
				if(paint)
					tempPaint.add("Paint"+stop);
			}
			long count = tempPaint.stream().distinct().count();
			numOfPaint = numOfPaint + (int)count;
		}
		return numOfPaint;
	}

}
