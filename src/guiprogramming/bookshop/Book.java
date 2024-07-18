package guiprogramming.bookshop;

public class Book {
	
	private int id ;
	private String authorName;
	private String bookName;
	private String editionYear;
	private String bookPrice;
	
	public Book () {
		
	}
	
	public Book(String authorName,String bookName,String editionYear,String bookPrice) {
		
		this.authorName=authorName;
		this.bookName=bookName;
		this.editionYear=editionYear;
		this.bookPrice=bookPrice;
		
	}
	public Book(int id,String authorName,String bookName,String editionYear,String bookPrice) {
		
		this.id=id;
		this.authorName=authorName;
		this.bookName=bookName;
		this.editionYear=editionYear;
		this.bookPrice=bookPrice;
		
	}
	
	
public void setId(int id ) {
		
		this.id =id;
	} 
	
	public int getId() {
		
		return this.id;
	}
	
	
	
	
	
	public void setAuthorName(String authorName ) {
		
		this.authorName =authorName;
	} 
	
	public String getAuthorName() {
		
		return this.authorName;
	}
	
public void setBookName(String bookName ) {
		
		this.bookName =bookName;
	} 
	
	public String getBookName() {
		
		return this.bookName;
	}
	
public void setEditionYear(String editionYear ) {
		
		this.editionYear =editionYear;
	} 
	
	public String getEditionYear() {
		
		return this.editionYear;
	}
	
public void setBookPrice(String bookPrice ) {
		
		this.bookPrice =bookPrice;
	} 
	
	public String getBookPrice() {
		
		return this.bookPrice;
	}
	

}
