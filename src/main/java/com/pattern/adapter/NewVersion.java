package com.pattern.adapter;

public class NewVersion implements Printer {

	private OldVersion oldVersion;

	public NewVersion() {
		this.oldVersion = new OldVersion();
	}

	@Override
	public void printX(String value) {
		System.out.printf("X ");
		oldVersion.printArrow(value);
	}

	@Override
	public void printShouting(String value) {
		System.out.printf("SHOUTING!!! ");
		oldVersion.printYell(value);
	}
}
