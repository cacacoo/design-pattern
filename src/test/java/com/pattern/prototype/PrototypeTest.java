package com.pattern.prototype;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrototypeTest {

	@Test
	public void testPrototype() {

		Manager manager = new Manager();

		Product checkBookProto = new Book("check book","foo",3000);
		Product noteBookProto = new Book("note book", null, 1500);
		Product macProto = new Computer("mac", 23000000);
		Product hpProto = new Computer("hp", 10000000);

		manager.regist("check book",checkBookProto);
		manager.regist("note book",noteBookProto);
		manager.regist("mac",macProto);
		manager.regist("hp",hpProto);


		Product checkBookClone = manager.createClone("check book");
		Product noteBookClone = manager.createClone("note book");
		Product macClone = manager.createClone("mac");
		Product hpClone = manager.createClone("hp");
		Product oracleClone = manager.createClone("oracle");

		checkBookClone.use();
		noteBookClone.use();
		macClone.use();
		hpClone.use();

		assertEquals(oracleClone, null);
	}
}
