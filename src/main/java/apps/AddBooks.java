package apps;

import business.Book;
import daos.BookDao;
import daos.BookDaoInterface;
import exceptions.DaoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * This class allows users to input book details and adds them to the database.
 * The details include book ID, title, author, and rental date.
 *
 * @author Oran
 */

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

        AddBook(bookid, title, currentDate, author, rentalDate);

    }
    /**
     * Adds a book to the database.
     *
     * @param bookid      The unique ID of the book.
     * @param title       The title of the book.
     * @param currentDate The current date when the book is added.
     * @param author      The author of the book.
     * @param rentalDate  The date when the book was rented.
     * @throws DaoException If a data access error occurs.
     */

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

