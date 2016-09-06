package com.pattern.template;

import com.google.common.collect.Maps;

import java.util.Map;

public class CanAssembler extends Assembler<Can> {

	private Map<String, Integer> canPriceMap;

	public CanAssembler() {
		initCanPriceMap();
	}

	private void initCanPriceMap() {
		this.canPriceMap = Maps.newHashMap();
		canPriceMap.put("맥콜",300);
		canPriceMap.put("콜라",400);
		canPriceMap.put("사이다",500);
	}

	@Override
	protected boolean validate(Can can) {
		return can == null || can.getName() == null ? false : true;
	}

	@Override
	protected void binding(Can can) {
		if(canPriceMap.containsKey(can.getName())) {
			can.setPrice(canPriceMap.get(can.getName()));
		}
	}

	@Override
	protected void execute(Can can) {
		System.out.printf("캔명:" + can.getName());
		System.out.println(" 금액:" + can.getPrice());
	}
}
