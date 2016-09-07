package com.pattern.singletone;

public class Single {
	private static Single instance = new Single();
	private static int count;

	private Single() {
		this.count++;
		System.out.println(count + "번째 single 생성!");
	}
	public static Single getInstance() {
		System.out.println(count + "번째 인스턴스 리턴");
		return instance;
	}
}
