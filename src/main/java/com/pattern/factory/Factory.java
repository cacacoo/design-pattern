package com.pattern.factory;

public abstract class Factory {
	public final Product create(String owner) {
		Product product = null;
		if(owner != null) {
			product = createProduct(owner);
			registerProduct(product);
		}
		return product;
	}

	protected abstract Product createProduct(String owner);
	protected abstract void registerProduct(Product product);
}
