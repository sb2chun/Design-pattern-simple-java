package behavioral;

import java.util.Iterator;

public class IteratorPattern {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(10);

		Book book1 = new Book("���е���");
		Book book2 = new Book("�ʹ� �ѳ��� ����");
		Book book3 = new Book("������ ����");

		bookShelf.appendBook(book2);
		bookShelf.appendBook(book3);
		bookShelf.appendBook(book1);

		System.out.println("���� �����ִ� å : " + bookShelf.getLength() + "��");

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
	private Book[] books; // å�� ����
	private int last = 0; // ������ å�� ���� ��ġ

	public BookShelf(int size) {
		books = new Book[size];
	}

	public Book getBook(int index) {
		return books[index];
	}

	public int getLength() {
		return last;
	}

	// å���̿� å�� �ȴ´�
	public void appendBook(Book book) {
		if (last < books.length) {
			this.books[last] = book;
			last++;
		} else {
			System.out.println("å���̰� �� á���ϴ�!");
		}
	}

	@Override
	public Iterator createIterator() {
		return new BookShelfIterator(this);
	}
}

class BookShelfIterator implements Iterator<Book> {
	private BookShelf bookShelf; // �˻��� ������ å����
	private int index = 0; // ���� ó���� å�� ��ġ

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