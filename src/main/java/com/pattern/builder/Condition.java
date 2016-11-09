package com.pattern.builder;

public class Condition<T> {

	private T specification;

	public Condition(T specification) {
		this.specification = specification;
	}

	public T getSpecification() {
		return specification;
	}
}
