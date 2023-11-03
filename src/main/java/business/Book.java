package business;


import java.sql.Date;
import java.util.Objects;

public class Book {

  private int bookid;
  private String title;
  private Date date;
  private String author;
  private Date rentaldate;


  public Book() {
  }

  public Book(int bookid, String title, Date date, String author, Date rentaldate) {
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getRentaldate() {
    return rentaldate;
  }

  public void setRentaldate(Date rentaldate) {
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