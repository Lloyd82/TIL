package BOOK;

public class BookDTO {

	private int isbn; //���� ��ȣ
	private String title; //���� ��
	private String author; //����
	private String publisher; //���ǻ�
	private int price; //����
	private String detail; //��
	private String publish_date; //������
	
	//�⺻������
	public BookDTO() {
		super();
	}
	//�����ε� ������
	public BookDTO(int isbn, String title, String author, String publisher, int price, String detail,
			String publish_date) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.detail = detail;
		this.publish_date = publish_date;
	}
	
	public int getisbn() {
		return isbn;
	}
	public void setisbn(int booknum) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "BookDTO [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", detail=" + detail + "]";
	}
}
 