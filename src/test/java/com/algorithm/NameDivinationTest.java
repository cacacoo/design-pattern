package com.algorithm;

import org.junit.Test;

public class NameDivinationTest {

	@Test
	public void test() {
		String myName = "홍길동";
		String otherName = "성춘향";
		NameDivination nameDivination = new NameDivination();
		nameDivination.divination(myName, otherName);
	}
}