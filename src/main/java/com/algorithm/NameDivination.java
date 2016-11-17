package com.algorithm;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 이름 점치기
 * 한글을 입력하면 해당 획수가 리턴되는 함수가 있다고 가정한다 (ln("권") -> return 8)
 */
public class NameDivination {

	private Map<String, Integer> stringWriteCountMap;

	public NameDivination() {
		stringWriteCountMap = Maps.newHashMap();
		stringWriteCountMap.put("홍", 6);
		stringWriteCountMap.put("길", 8);
		stringWriteCountMap.put("동", 6);
		stringWriteCountMap.put("성", 5);
		stringWriteCountMap.put("춘", 8);
		stringWriteCountMap.put("향", 7);
	}

	private int ln(char str) {
		return stringWriteCountMap.get(String.valueOf(str));
	}

	public void divination(String myName, String otherName) {
		char[] myNameArr = myName.toCharArray();
		char[] otherNameArr = otherName.toCharArray();

		int maxLength = myNameArr.length >= otherNameArr.length? myNameArr.length : otherNameArr.length;
		int[][] nameCountArr = new int[maxLength][maxLength];

		for(int idx=0; idx < maxLength; idx++) {
			nameCountArr[idx][idx] = (ln(myNameArr[idx]) + ln(otherNameArr[idx])) % 10;
			if(idx+1 <= maxLength) {
				nameCountArr[idx][idx+1] = (ln(myNameArr[idx+1]) + ln(otherNameArr[idx])) % 10;
			}
		}

		int[] divinationArr = recursive(flat(nameCountArr));
		System.out.println(divinationArr[0] + "" + divinationArr[1]+"%");
	}

	private int[] flat(int[][] nameCountArr) {
		return new int[0];
	}

	private int[] recursive(int[] divinationArr) {
		if(divinationArr.length <= 2) {
			return divinationArr;
		}

		int length = divinationArr.length;
		int[] arr = new int[length-1];
		for(int idx=0; idx < divinationArr.length; idx++) {
			int sum = divinationArr[idx] + divinationArr[idx+1];
			arr[idx] = sum >= 10 ? sum-10 : sum;
		}
		return recursive(arr);
	}
}
