package com.pattern.prototype;

public class Computer implements Product {

	private String name;
	private int price;

	public Computer(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public void use() {
		System.out.println("name:" + name );
		System.out.println("price:" + price );
	}

	@Override
	public Product createClone() {
		Product clone = null;
		try {
			clone = (Product) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
