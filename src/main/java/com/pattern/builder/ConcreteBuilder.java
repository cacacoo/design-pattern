package com.pattern.builder;

public class ConcreteBuilder extends Builder<Concrete> {

	@Override
	void validate(Condition condition) {

		ConcreteSearchCondition concreteSearchCondition = (ConcreteSearchCondition) condition.getSpecification();


	}

	@Override
	Preset aggregate(Condition condition) {
		return null;
	}

	@Override
	Concrete bind(Preset preset) {
		return null;
	}
}
