package com.pattern.prototype;

public class Book implements Product {

	private String name;
	private String author;
	private int price;

	public Book(String name, String author, int price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}

	@Override
	public void use() {
		System.out.println("name:" + name );
		System.out.println("author:" + author );
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
