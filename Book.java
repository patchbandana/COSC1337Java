/* Eman Eizenga
 * COSC 1337 001
 * 2023-10-23
 * Purpose: To encapsulate a Book (Lab9L2)
 */
package bookstore;

/** Encapsulates a Book, including a title, an author, and a retail price
 * @author eeizenga
 */
public class Book {
	/**The tile of the Book*/
	private String title;
	/**The author of the Book*/
	private String author;
	/**The retail price of the Book*/
	private double retailPrice;
	/**Creates a new Book with an empty title, empty author, and a price
	 * 	of 0.00.
	 * 
	 */
	public Book() {
		setTitle(" ");
		setAuthor(" ");
		setRetailPrice(0.00);
	}

	/** Creates a new Book with input data
	 * @param title The title of the Book
	 * @param author The author of the Book
	 * @param retailPrice The retail price of the Book
	 */
	public Book(String title, String author, double retailPrice) {
		setTitle(title);
		setAuthor(author);
		setRetailPrice(retailPrice);
	}

	/**Gets the title of the Book
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**Sets the title of the Book
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**Gets the author of the Book
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**Sets the author of the Book
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**Gets the retailPrice of the Book
	 * @return the retailPrice
	 */
	public double getRetailPrice() {
		return retailPrice;
	}

	/**Sets the retailPrice of the book
	 * @param retailPrice the retailPrice to set
	 */
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	/**Returns a string version of the Book
	 * 
	 * @return a string version of the Book
	 */
	@Override
	public String toString() {
		return "Title: " + getTitle() + "\tAuthor: " + getAuthor() +
				"\tRetail Price: " + getRetailPrice();
	}

	/**Returns true iff the Books have the same data
	 * 
	 * @param o the object to compare this Book to
	 * @return true iff the Books have the same data
	 */
	@Override
	public boolean equals(Object o) {
		return toString().equals(o.toString());
	}
}