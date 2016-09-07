package com.pattern.factory;

import com.google.common.collect.Lists;

import java.util.List;

public class IDCardFactory extends Factory {

	private List<Product> idCardList;

	public IDCardFactory() {
		this.idCardList = Lists.newArrayList();
	}

	@Override
	public Product createProduct(String owner) {
		System.out.println(owner +"의 ID카드가 생성되었습니다.");
		return new IdCard(owner);
	}

	@Override
	public void registerProduct(Product product) {
		System.out.println("ID카드가 등록되었습니다.");
		idCardList.add(product);
	}
}
