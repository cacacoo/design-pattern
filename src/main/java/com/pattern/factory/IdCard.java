package com.pattern.factory;

public class IdCard implements Product {

	private String owner;

	public IdCard(String owner) {
		this.owner = owner;
	}

	@Override
	public void use() {
		System.out.printf(owner+ "이(가) 카드를 사용했습니다.");
	}
}
