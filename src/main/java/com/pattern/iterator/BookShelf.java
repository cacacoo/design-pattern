package com.pattern.iterator;

import com.google.common.collect.Lists;

import java.util.List;

public class BookShelf implements Aggregator{

	private List<Book> myBooks;
	private int last;

	public BookShelf() {
		this.myBooks = Lists.newArrayList();
		this.last = 0;
	}

	public Book getBookAt(int index) {
		return myBooks.get(index);
	}

	public int size() {
		return last;
	}

	public void appendBook(Book book) {
		myBooks.add(book);
		last++;
	}

	@Override
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
}
