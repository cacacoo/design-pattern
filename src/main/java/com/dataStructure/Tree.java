package com.dataStructure;

public interface Tree<T> {

	int height();
	long totalNode();

	void save(T key);
	void delete(T key);

}
