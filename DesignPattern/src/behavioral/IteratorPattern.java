package behavioral;

import java.util.Iterator;

public class IteratorPattern {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(10);

		Book book1 = new Book("문학동네");
		Book book2 = new Book("너무 한낮의 연애");
		Book book3 = new Book("늑대의 문장");

		bookShelf.appendBook(book2);
		bookShelf.appendBook(book3);
		bookShelf.appendBook(book1);

		System.out.println("현재 꽂혀있는 책 : " + bookShelf.getLength() + "권");

		Iterator it = bookShelf.createIterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			System.out.println(book.getName());
		}

	}
}

class Book {
	private String name;

	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

interface Aggregate {

	Iterator createIterator();
}

class BookShelf implements Aggregate {
	private Book[] books; // 책의 집합
	private int last = 0; // 마지막 책이 꽂힌 위치

	public BookShelf(int size) {
		books = new Book[size];
	}

	public Book getBook(int index) {
		return books[index];
	}

	public int getLength() {
		return last;
	}

	// 책꽂이에 책을 꽂는다
	public void appendBook(Book book) {
		if (last < books.length) {
			this.books[last] = book;
			last++;
		} else {
			System.out.println("책꽂이가 꽉 찼습니다!");
		}
	}

	@Override
	public Iterator createIterator() {
		return new BookShelfIterator(this);
	}
}

class BookShelfIterator implements Iterator<Book> {
	private BookShelf bookShelf; // 검색을 수행할 책꽂이
	private int index = 0; // 현재 처리할 책의 위치

	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
	}

	@Override
	public boolean hasNext() {
		return index < bookShelf.getLength();
	}

	@Override
	public Book next() {
		Book book = bookShelf.getBook(index);
		index++;
		return book;
	}
}