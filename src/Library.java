import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<Book> books;
    private ActivityStack activityStack;

    public Library() {
        this.books = new ArrayList<>();
        this.activityStack = new ActivityStack();
    }

    // Book Management
    public void addBook(Book book) {
        books.add(book);
        activityStack.push("Added book: " + book.getTitle());
    }

    public boolean removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                Book removed = books.remove(i);
                activityStack.push("Removed book: " + removed.getTitle());
                return true;
            }
        }
        return false;
    }

    public boolean updateBook(String isbn, String title, String author, int publicationYear, String genre) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setPublicationYear(publicationYear);
                book.setGenre(genre);
                activityStack.push("Updated book: " + book.getTitle());
                return true;
            }
        }
        return false;
    }

    // Getters
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ActivityStack getActivityStack() {
        return activityStack;
    }

    // Borrowing
    public boolean borrowBook(String isbn, String borrower) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.getBorrowingHistory().addBorrower(borrower);
                activityStack.push("Borrowed book: " + book.getTitle() + " by " + borrower);
                return true;
            }
        }
        return false;
    }

    // Search Functionality
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                activityStack.push("Searched for title: " + title);
                return book;
            }
        }
        return null;
    }

    public Book linearSearchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                activityStack.push("Searched for author: " + author);
                return book;
            }
        }
        return null;
    }

    public Book linearSearchByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                activityStack.push("Searched for ISBN: " + isbn);
                return book;
            }
        }
        return null;
    }

    // Binary Search - assumes list is sorted by the key
    public Book binarySearchByTitle(String title) {
        // Sort by title first
        ArrayList<Book> sortedBooks = new ArrayList<>(books);
        bubbleSortByTitle(sortedBooks);
        int left = 0, right = sortedBooks.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedBooks.get(mid).getTitle().compareToIgnoreCase(title);
            if (cmp == 0) {
                activityStack.push("Binary searched for title: " + title);
                return sortedBooks.get(mid);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Book binarySearchByAuthor(String author) {
        ArrayList<Book> sortedBooks = new ArrayList<>(books);
        bubbleSortByAuthor(sortedBooks);
        int left = 0, right = sortedBooks.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedBooks.get(mid).getAuthor().compareToIgnoreCase(author);
            if (cmp == 0) {
                activityStack.push("Binary searched for author: " + author);
                return sortedBooks.get(mid);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Book binarySearchByIsbn(String isbn) {
        ArrayList<Book> sortedBooks = new ArrayList<>(books);
        bubbleSortByIsbn(sortedBooks);
        int left = 0, right = sortedBooks.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedBooks.get(mid).getIsbn().compareTo(isbn);
            if (cmp == 0) {
                activityStack.push("Binary searched for ISBN: " + isbn);
                return sortedBooks.get(mid);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Sorting Functionality
    public void bubbleSortByTitle(ArrayList<Book> bookList) {
        int n = bookList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bookList.get(j).getTitle().compareToIgnoreCase(bookList.get(j + 1).getTitle()) > 0) {
                    Book temp = bookList.get(j);
                    bookList.set(j, bookList.get(j + 1));
                    bookList.set(j + 1, temp);
                }
            }
        }
    }

    public void bubbleSortByAuthor(ArrayList<Book> bookList) {
        int n = bookList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bookList.get(j).getAuthor().compareToIgnoreCase(bookList.get(j + 1).getAuthor()) > 0) {
                    Book temp = bookList.get(j);
                    bookList.set(j, bookList.get(j + 1));
                    bookList.set(j + 1, temp);
                }
            }
        }
    }

    public void bubbleSortByPublicationYear(ArrayList<Book> bookList) {
        int n = bookList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bookList.get(j).getPublicationYear() > bookList.get(j + 1).getPublicationYear()) {
                    Book temp = bookList.get(j);
                    bookList.set(j, bookList.get(j + 1));
                    bookList.set(j + 1, temp);
                }
            }
        }
    }

    public void bubbleSortByIsbn(ArrayList<Book> bookList) {
        int n = bookList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bookList.get(j).getIsbn().compareTo(bookList.get(j + 1).getIsbn()) > 0) {
                    Book temp = bookList.get(j);
                    bookList.set(j, bookList.get(j + 1));
                    bookList.set(j + 1, temp);
                }
            }
        }
    }

    // Selection Sort
    public void selectionSortByTitle(ArrayList<Book> bookList) {
        int n = bookList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (bookList.get(j).getTitle().compareToIgnoreCase(bookList.get(minIndex).getTitle()) < 0) {
                    minIndex = j;
                }
            }
            Book temp = bookList.get(minIndex);
            bookList.set(minIndex, bookList.get(i));
            bookList.set(i, temp);
        }
    }

    public void selectionSortByAuthor(ArrayList<Book> bookList) {
        int n = bookList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (bookList.get(j).getAuthor().compareToIgnoreCase(bookList.get(minIndex).getAuthor()) < 0) {
                    minIndex = j;
                }
            }
            Book temp = bookList.get(minIndex);
            bookList.set(minIndex, bookList.get(i));
            bookList.set(i, temp);
        }
    }

    public void selectionSortByPublicationYear(ArrayList<Book> bookList) {
        int n = bookList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (bookList.get(j).getPublicationYear() < bookList.get(minIndex).getPublicationYear()) {
                    minIndex = j;
                }
            }
            Book temp = bookList.get(minIndex);
            bookList.set(minIndex, bookList.get(i));
            bookList.set(i, temp);
        }
    }

    // Quicksort
    public void quickSortByTitle(ArrayList<Book> bookList, int low, int high) {
        if (low < high) {
            int pi = partitionByTitle(bookList, low, high);
            quickSortByTitle(bookList, low, pi - 1);
            quickSortByTitle(bookList, pi + 1, high);
        }
    }

    private int partitionByTitle(ArrayList<Book> bookList, int low, int high) {
        Book pivot = bookList.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (bookList.get(j).getTitle().compareToIgnoreCase(pivot.getTitle()) <= 0) {
                i++;
                Book temp = bookList.get(i);
                bookList.set(i, bookList.get(j));
                bookList.set(j, temp);
            }
        }
        Book temp = bookList.get(i + 1);
        bookList.set(i + 1, bookList.get(high));
        bookList.set(high, temp);
        return i + 1;
    }

    public void quickSortByAuthor(ArrayList<Book> bookList, int low, int high) {
        if (low < high) {
            int pi = partitionByAuthor(bookList, low, high);
            quickSortByAuthor(bookList, low, pi - 1);
            quickSortByAuthor(bookList, pi + 1, high);
        }
    }

    private int partitionByAuthor(ArrayList<Book> bookList, int low, int high) {
        Book pivot = bookList.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (bookList.get(j).getAuthor().compareToIgnoreCase(pivot.getAuthor()) <= 0) {
                i++;
                Book temp = bookList.get(i);
                bookList.set(i, bookList.get(j));
                bookList.set(j, temp);
            }
        }
        Book temp = bookList.get(i + 1);
        bookList.set(i + 1, bookList.get(high));
        bookList.set(high, temp);
        return i + 1;
    }

    public void quickSortByPublicationYear(ArrayList<Book> bookList, int low, int high) {
        if (low < high) {
            int pi = partitionByPublicationYear(bookList, low, high);
            quickSortByPublicationYear(bookList, low, pi - 1);
            quickSortByPublicationYear(bookList, pi + 1, high);
        }
    }

    private int partitionByPublicationYear(ArrayList<Book> bookList, int low, int high) {
        Book pivot = bookList.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (bookList.get(j).getPublicationYear() <= pivot.getPublicationYear()) {
                i++;
                Book temp = bookList.get(i);
                bookList.set(i, bookList.get(j));
                bookList.set(j, temp);
            }
        }
        Book temp = bookList.get(i + 1);
        bookList.set(i + 1, bookList.get(high));
        bookList.set(high, temp);
        return i + 1;
    }

    // Public methods to sort the main list
    public void sortBooks(String criterion, String algorithm) {
        ArrayList<Book> bookList = new ArrayList<>(books);
        switch (algorithm.toLowerCase()) {
            case "bubble":
                switch (criterion.toLowerCase()) {
                    case "title":
                        bubbleSortByTitle(bookList);
                        break;
                    case "author":
                        bubbleSortByAuthor(bookList);
                        break;
                    case "year":
                        bubbleSortByPublicationYear(bookList);
                        break;
                }
                break;
            case "selection":
                switch (criterion.toLowerCase()) {
                    case "title":
                        selectionSortByTitle(bookList);
                        break;
                    case "author":
                        selectionSortByAuthor(bookList);
                        break;
                    case "year":
                        selectionSortByPublicationYear(bookList);
                        break;
                }
                break;
            case "quick":
                switch (criterion.toLowerCase()) {
                    case "title":
                        quickSortByTitle(bookList, 0, bookList.size() - 1);
                        break;
                    case "author":
                        quickSortByAuthor(bookList, 0, bookList.size() - 1);
                        break;
                    case "year":
                        quickSortByPublicationYear(bookList, 0, bookList.size() - 1);
                        break;
                }
                break;
        }
        books = bookList;
        activityStack.push("Sorted books by " + criterion + " using " + algorithm);
    }
}