package com.pattern.iterator;

import org.junit.Before;
import org.junit.Test;



public class BookShelfTest {

	BookShelf myBookShelf = new BookShelf();

	@Before
	public void init() {
		Book toby = new Book("토비");
		Book funtional = new Book("함수형사고");
		Book es6 = new Book("es6");
		Book git = new Book("git");

		myBookShelf.appendBook(toby);
		myBookShelf.appendBook(funtional);
		myBookShelf.appendBook(es6);
		myBookShelf.appendBook(git);
	}

	@Test
	public void testIterator() throws Exception {
		Iterator<Book> bookIterator = myBookShelf.iterator();
		while (bookIterator.hasNext()) {
			System.out.println(bookIterator.next().getName());
		}
	}
}