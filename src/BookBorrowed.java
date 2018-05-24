
public class BookBorrowed {
	private Book book;
	private String username;
	
	public BookBorrowed(Book book, String username) {
		super();
		this.book = book;
		this.username = username;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
