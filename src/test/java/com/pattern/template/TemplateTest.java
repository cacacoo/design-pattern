package com.pattern.template;

import org.junit.Test;

public class TemplateTest{

	@Test
	public void testTemplate() throws Exception {

		Assembler assembler = new CanAssembler();

		Can mac = new Can("맥콜");
		assembler.assemble(mac);

		Can fanta = new Can("판타");
		assembler.assemble(fanta);

		Can coke = new Can("콜라");
		assembler.assemble(coke);

		Can emptyCan = new Can(null);
		assembler.assemble(emptyCan);

	}

}
