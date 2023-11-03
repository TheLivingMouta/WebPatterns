package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a Data Transfer Object (DTO) for a book with various attributes such as book ID, title, publication date, author, and rental date.
 *
 * @author Oran
 */
public class Book implements Serializable {
  private int bookid;
  private String title;
  private LocalDate date;
  private String author;
  private LocalDate rentaldate;

  /**
   * Default constructor for the Book DTO.
   */
  public Book() {
  }

  /**
   * Parameterized constructor to initialize a Book DTO with specific values.
   *
   * @param bookid     The unique identifier for the book.
   * @param title      The title of the book.
   * @param date       The date the book was added to the library.
   * @param author     The author of the book.
   * @param rentaldate The date when the book was rented.
   */

  public Book(int bookid, String title, LocalDate date, String author, LocalDate rentaldate) {
    this.bookid = bookid;
    this.title = title;
    this.date = date;
    this.author = author;
    this.rentaldate = rentaldate;
  }

  public int getBookid() {
    return bookid;
  }

  public void setBookid(int bookid) {
    this.bookid = bookid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public LocalDate getRentaldate() {
    return rentaldate;
  }

  public void setRentaldate(LocalDate rentaldate) {
    this.rentaldate = rentaldate;
  }

  @Override
  public String toString() {
    return "Book{" +
            "bookid=" + bookid +
            ", title='" + title + '\'' +
            ", date=" + date +
            ", author='" + author + '\'' +
            ", rentaldate=" + rentaldate +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return bookid == book.bookid;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookid);
  }
}
