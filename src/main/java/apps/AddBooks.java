package apps;

import business.Book;
import daos.BookDao;
import daos.BookDaoInterface;
import exceptions.DaoException;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AddBooks {
    public static void main(String[] args) throws DaoException {


        Scanner sc = new Scanner(System.in);
        String dateFormat = "dd/MM/yyyy";
        boolean valid = false;
        LocalDate currentDate = LocalDate.now();
        LocalDate rentalDate = null;


        System.out.print("Enter book details:\n");
        System.out.print("Enter id: ");
        int bookid = sc.nextInt();
//        Consumes a new line
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();


        while (!valid) {
            System.out.println("Enter rental date in the format:" + dateFormat);
            String dateText = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            try {
                rentalDate = LocalDate.parse(dateText, formatter);
                System.out.println(rentalDate.getDayOfWeek() + ", " + rentalDate.getMonth() + ", " + rentalDate.getYear());
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format used. Please try again");
            }
        }
//        TODO add timestamp to both dates

        AddBook(bookid, title, currentDate, author, rentalDate);

    }

    public static void AddBook(int bookid, String title ,LocalDate currentDate,  String author, LocalDate rentalDate) throws DaoException {

        System.out.println("AddBooks()");
        try {
            BookDaoInterface dao = new BookDao();
            Book b = new Book(bookid, title, currentDate, author, rentalDate);

            boolean rowsAffected = dao.addBook(b);
            System.out.println(title + " added successfully");
            if (!rowsAffected) {
                System.out.println("No book was added" + b);
            } else System.out.println(b);

        } catch (DaoException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}

