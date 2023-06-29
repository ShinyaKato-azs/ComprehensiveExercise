package com.example.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class itemServiceImplTest {

	ItemServiceImpl itemServiceImpl = new ItemServiceImpl();

	@Test
	void threeLettersTest() {

		String trimmedMessage = itemServiceImpl.trimFormName("とまと");
		String expected = "とま";

		assertEquals(expected, trimmedMessage);

	}

	@Test
	void twoLettersTest() {

		String trimmedMessage = itemServiceImpl.trimFormName("かぶ");
		String expected = "か";

		assertEquals(expected, trimmedMessage);

	}

	@Test
	void oneLetterTest() {

		String trimmedMessage = itemServiceImpl.trimFormName("あ");
		String expected = "";

		assertEquals(expected, trimmedMessage);

	}

	@Test
	void emptyCharTest() {

		assertThrows(IllegalArgumentException.class, () -> {
			itemServiceImpl.trimFormName("");
		});

	}

}
