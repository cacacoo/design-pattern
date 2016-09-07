package com.pattern.prototype;

public interface Product extends Cloneable {
	void use();
	Product createClone();
}
