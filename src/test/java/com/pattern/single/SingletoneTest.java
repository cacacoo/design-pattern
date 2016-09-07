package com.pattern.single;

import com.pattern.singletone.Single;
import org.junit.Test;

public class SingletoneTest {

	@Test
	public void testSingletone() {
		Single single = Single.getInstance();
		Single single2 = Single.getInstance();
	}

}
