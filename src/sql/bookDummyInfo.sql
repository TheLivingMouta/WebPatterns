-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 05, 2023 at 11:38 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bookid`, `title`, `date`, `author`, `rentaldate`) VALUES
                                                                            (1, 'The Great Gatsby', '2023-11-11 00:00:00', 'F. Scott Fitzgerald', '2023-11-03 00:00:00'),
                                                                            (2, 'The Book Thief', '2023-11-03 16:46:08', 'Markus Zusak', '2023-11-03 16:46:08'),
                                                                            (3, 'The Lord of the Rings', '2023-11-03 16:48:50', 'J. R. R. Tolkien', '2023-11-29 15:48:50'),
                                                                            (4, 'To Kill a Mockingbird', '2023-11-03 16:50:13', 'Harper Lee', '2023-11-03 16:50:13'),
                                                                            (5, 'The Hobbit', '2023-11-03 16:51:55', ' J. R. R. Tolkien', '2023-11-30 15:51:56'),
                                                                            (6, 'Harry Potter and the Sorcerer\'s Stone', '2023-11-03 16:51:55', 'J. K. Rowling', '2023-11-03 16:51:55'),
                                                                            (7, 'The Catcher in the Rye', '2023-11-03 16:53:43', 'J. D. Salinger', '2023-11-22 15:53:43'),
                                                                            (8, 'Diary of a Wimpy Kid: No Brainer', '2023-11-03 16:54:03', 'Jeff Kinney', '2023-11-14 15:54:03'),
                                                                            (9, 'Gone Girl', '2023-11-03 16:55:08', 'Gillian Flynn', '2023-11-23 15:55:08'),
                                                                            (10, 'Divergent', '2023-11-04 00:00:00', 'Veronica Roth', '2023-11-23 00:00:00'),
                                                                            (11, 'Insurgent', '2023-11-04 00:00:00', 'Veronica Roth', '2023-11-23 00:00:00'),
                                                                            (12, 'Allegiant', '2023-11-04 00:00:00', 'Veronica Roth', '2023-11-23 00:00:00'),
                                                                            (13, 'Four: A Divergent Collection', '2023-11-04 00:00:00', 'Veronica Roth', '2023-11-23 00:00:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
