package business;


import java.util.Objects;

public class Loan {

  private int bookid;
  private int userid;
  private int rentaldate;
  private int rentalprice;

  public Loan() {
  }

  public Loan(int bookid, int userid, int rentaldate, int rentalprice) {
    this.bookid = bookid;
    this.userid = userid;
    this.rentaldate = rentaldate;
    this.rentalprice = rentalprice;
  }

  public int getBookid() {
    return bookid;
  }

  public void setBookid(int bookid) {
    this.bookid = bookid;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public int getRentaldate() {
    return rentaldate;
  }

  public void setRentaldate(int rentaldate) {
    this.rentaldate = rentaldate;
  }

  public int getRentalprice() {
    return rentalprice;
  }

  public void setRentalprice(int rentalprice) {
    this.rentalprice = rentalprice;
  }

  @Override
  public String toString() {
    return "Loan{" +
            "bookid=" + bookid +
            ", userid=" + userid +
            ", rentaldate=" + rentaldate +
            ", rentalprice=" + rentalprice +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Loan loan = (Loan) o;
    return bookid == loan.bookid && userid == loan.userid;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookid, userid);
  }
}
