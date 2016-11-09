package com.pattern.builder;

public abstract class Builder<T> {

	public final T build(Condition condition) {

		validate(condition);

		Preset preset = aggregate(condition);

		return bind(preset);
	}

	abstract void validate(Condition condition);

	abstract Preset aggregate(Condition condition);

	abstract T bind(Preset preset);
}
