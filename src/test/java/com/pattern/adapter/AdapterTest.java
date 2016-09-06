package com.pattern.adapter;

import org.junit.Test;

public class AdapterTest {

	@Test
	public void testAdapter() throws Exception {

		//자 old version을 쓰다가~
//		OldVersion oldVersion = new OldVersion();
//		oldVersion.printArrow("yes!");
//		oldVersion.printYell("yes!");

		//new version으로 바꿔치기가 필요한 상황이 온 경우
		//이경우는 하지만 oldVersion의 interface와 동일하게 바꿔치기가 가능한 경우에 용이해진다

		//혹은 old version에 기능에 좀더 추가해서 new version을 만들어야된 경우
		Printer printer = new NewVersion();
		printer.printShouting("yes!");
		printer.printX("yes!");
	}

}