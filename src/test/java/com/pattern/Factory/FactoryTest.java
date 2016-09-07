package com.pattern.Factory;

import com.pattern.factory.IDCardFactory;
import com.pattern.factory.Product;
import org.junit.Test;

public class FactoryTest {

	@Test
	public void testFactory() {

		IDCardFactory cardFactory = new IDCardFactory();
		Product foo = cardFactory.create("foo");
		foo.use();

		Product bar = cardFactory.create("bar");
		bar.use();
	}
}
