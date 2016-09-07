package com.pattern.prototype;

import com.google.common.collect.Maps;

import java.util.HashMap;

public class Manager {

	private HashMap hashMap;

	public Manager() {
		this.hashMap = Maps.newHashMap();
	}

	public void regist(String name,Product proto) {
		hashMap.put(name, proto);
	}

	public Product createClone(String name) {
		Product proto = (Product) hashMap.get(name);
		if(proto == null) {
			return null;
		}
		return proto.createClone();
	}

}
