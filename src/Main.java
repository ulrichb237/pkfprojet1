import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Add some sample books
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5", 1925, "Fiction"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", 1960, "Fiction"));
        library.addBook(new Book("1984", "George Orwell", "978-0-452-28423-4", 1949, "Dystopian"));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8", 1813, "Romance"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book (Linear)");
            System.out.println("5. Search Book (Binary)");
            System.out.println("6. Sort Books");
            System.out.println("7. Borrow Book");
            System.out.println("8. View Recent Activities");
            System.out.println("9. View Borrowing History");
            System.out.println("10. List All Books");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Publication Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn, year, genre));
                    System.out.println("Book added.");
                    break;
                case 2:
                    System.out.print("ISBN to remove: ");
                    String removeIsbn = scanner.nextLine();
                    if (library.removeBook(removeIsbn)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("ISBN to update: ");
                    String updateIsbn = scanner.nextLine();
                    System.out.print("New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("New Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("New Publication Year: ");
                    int newYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Genre: ");
                    String newGenre = scanner.nextLine();
                    if (library.updateBook(updateIsbn, newTitle, newAuthor, newYear, newGenre)) {
                        System.out.println("Book updated.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("Search by: 1. Title 2. Author 3. ISBN");
                    int searchType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Query: ");
                    String query = scanner.nextLine();
                    Book found = null;
                    switch (searchType) {
                        case 1:
                            found = library.linearSearchByTitle(query);
                            break;
                        case 2:
                            found = library.linearSearchByAuthor(query);
                            break;
                        case 3:
                            found = library.linearSearchByIsbn(query);
                            break;
                    }
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.println("Search by: 1. Title 2. Author 3. ISBN");
                    int binSearchType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Query: ");
                    String binQuery = scanner.nextLine();
                    Book binFound = null;
                    switch (binSearchType) {
                        case 1:
                            binFound = library.binarySearchByTitle(binQuery);
                            break;
                        case 2:
                            binFound = library.binarySearchByAuthor(binQuery);
                            break;
                        case 3:
                            binFound = library.binarySearchByIsbn(binQuery);
                            break;
                    }
                    if (binFound != null) {
                        System.out.println("Found: " + binFound);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    System.out.println("Sort by: 1. Title 2. Author 3. Year");
                    int sortCrit = scanner.nextInt();
                    scanner.nextLine();
                    String criterion = "";
                    switch (sortCrit) {
                        case 1:
                            criterion = "title";
                            break;
                        case 2:
                            criterion = "author";
                            break;
                        case 3:
                            criterion = "year";
                            break;
                    }
                    System.out.println("Algorithm: 1. Bubble 2. Selection 3. Quick");
                    int alg = scanner.nextInt();
                    scanner.nextLine();
                    String algorithm = "";
                    switch (alg) {
                        case 1:
                            algorithm = "bubble";
                            break;
                        case 2:
                            algorithm = "selection";
                            break;
                        case 3:
                            algorithm = "quick";
                            break;
                    }
                    library.sortBooks(criterion, algorithm);
                    System.out.println("Books sorted.");
                    break;
                case 7:
                    System.out.print("ISBN to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    System.out.print("Borrower name: ");
                    String borrower = scanner.nextLine();
                    if (library.borrowBook(borrowIsbn, borrower)) {
                        System.out.println("Book borrowed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 8:
                    System.out.println("Recent Activities:");
                    for (String activity : library.getActivityStack().getAllActivities()) {
                        System.out.println(activity);
                    }
                    break;
                case 9:
                    System.out.print("ISBN for history: ");
                    String histIsbn = scanner.nextLine();
                    Book histBook = library.linearSearchByIsbn(histIsbn);
                    if (histBook != null) {
                        System.out.println("Borrowing History: " + histBook.getBorrowingHistory().getBorrowers());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 10:
                    System.out.println("All Books:");
                    for (Book b : library.getBooks()) {
                        System.out.println(b);
                    }
                    break;
                case 11:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}