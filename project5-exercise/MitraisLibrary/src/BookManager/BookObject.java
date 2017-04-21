package BookManager;

import java.io.Serializable;

public class BookObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long Id;
	private String ISBN;
	private String Title;
	private String Author;
	private String Publisher;
	private Integer Price;

	public BookObject() {
		// TODO Auto-generated constructor stub
	}

	public BookObject(Long Id, String ISBN, String Title, String Author, String Publisher, Integer Price) {
		this.Id = Id;
		this.ISBN = ISBN;
		this.Author = Author;
		this.Price = Price;
		this.Publisher = Publisher;
		this.Title = Title;
	}

	@Override
	public BookObject clone() {
		return new BookObject(Id, ISBN, Title, Author, Publisher, Price);
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void restore(BookObject bookObject) {
		// TODO Auto-generated method stub
		this.Id = bookObject.getId();
		this.ISBN = bookObject.getISBN();
		this.Author = bookObject.getAuthor();
		this.Price = bookObject.getPrice();
		this.Publisher = bookObject.getPublisher();
		this.Title = bookObject.getTitle();
	}

}