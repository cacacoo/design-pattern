package com.pattern.template;

public abstract class Assembler<T> {
	public void assemble(T product) {
		if(validate(product)) {
			binding(product);
			execute(product);
		}
	}

	protected abstract void execute(T product);

	protected abstract void binding(T product);

	protected abstract boolean validate(T product);
}
