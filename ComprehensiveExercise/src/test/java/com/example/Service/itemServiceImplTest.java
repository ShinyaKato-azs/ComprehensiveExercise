package com.example.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class itemServiceImplTest {

	ItemServiceImpl itemServiceImpl = new ItemServiceImpl();

	@Test
	void test1() {

		String trimmedMessage = itemServiceImpl.trimFormName("きゅうり");
		String expected = "きゅう";

		assertEquals(expected, trimmedMessage);

	}

	@Test
	void test2() {

		String trimmedMessage = itemServiceImpl.trimFormName("とまと");
		String expected = "とま";

		assertEquals(expected, trimmedMessage);

	}

	@Test
	void test3() {

		String trimmedMessage = itemServiceImpl.trimFormName("とまと ");
		String expected = "とまと";

		assertEquals(expected, trimmedMessage);

	}

	@Test
	void test4() {

		String trimmedMessage = itemServiceImpl.trimFormName("あ");
		String expected = "";

		assertEquals(expected, trimmedMessage);

	}

	@Test
	void test5() {

		String trimmedMessage = itemServiceImpl.trimFormName("corn");
		String expected = "cor";

		assertEquals(expected, trimmedMessage);

	}

}
