package com.example.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.example.items.Items;
import com.example.repository.ItemsRepository;
import com.example.service.ItemServiceImpl;

@SpringBootTest
class itemServiceImplTest {
	@SpyBean
	private ItemsRepository repository;
	@Autowired
	ItemServiceImpl itemServiceImpl;
	//	ItemServiceImpl itemServiceImpl = new ItemServiceImpl();

	/**
	 * trimFormNameメソッドのテストです
	 */
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

	/**
	 * getItemsメソッドのテストです
	 */
	@Test
	void getItemsTest() {

		Items mockItem = new Items();
		mockItem.setId(1);
		mockItem.setName("ごぼう");
		/** mockの配列を用意する */
		List<Items> mockItemsList = new ArrayList<>();
		mockItemsList.add(mockItem);

		/** getItemsが呼び出されたらmockの配列を返す */
		Mockito.when(itemServiceImpl.getItems()).thenReturn(mockItemsList);
		/** 以下はmockito.whenが機能しているかのチェック */
		Items expectedItem = itemServiceImpl.getItems().get(0);
		int expectedId = expectedItem.getId();
		String expectedName = expectedItem.getName();
		/** 等価チェック */
		assertEquals(1, expectedId);
		assertEquals("ごぼう", expectedName);

	}

}
