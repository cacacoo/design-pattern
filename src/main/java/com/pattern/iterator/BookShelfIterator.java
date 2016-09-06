package com.pattern.iterator;

public class BookShelfIterator implements Iterator<Book> {

	private BookShelf bookShelf;
	private int index;

	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		return  index < bookShelf.size() ? true : false;
	}

	@Override
	public Book next() {
		int point = index;
		index++;
		return bookShelf.getBookAt(point);
	}
}
