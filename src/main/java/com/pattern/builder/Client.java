package com.pattern.builder;

public class Client {

	public static void main(String[] args) {

		Builder<Concrete> builder = new ConcreteBuilder();

		int price = 1;
		String name = "bart";

		ConcreteSearchCondition spec = new ConcreteSearchCondition(name, price);

		Concrete concrete = builder.build(new Condition(spec));

	}
}
