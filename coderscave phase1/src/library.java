import java.util.ArrayList;
import java.util.*;

class Library {
    private List<Book> Books;
    private List<user> users;
    private List<br> borrowingRecords;

    public Library() {
        this.Books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.borrowingRecords = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        Books.add(book);
    }

    // Add User
    public void addUser(user user) {
        users.add(user);
    }

    // Borrow Book
    public void borrowBook(Book book, user user) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            br record = new br(borrowingRecords.size() + 1, book, user, new Date());
            borrowingRecords.add(record);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    // Return Book
    public void returnBook(Book book, user user) {
        for (br record : borrowingRecords) {
            if (record.getBook().equals(book) && record.getUser().equals(user)) {
                record.setReturnDate(new Date());
                book.setAvailable(true);
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("No such borrowing record found.");
    }

    // Display Books
    public void displayBooks() {
        for (Book book : Books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Publication Year: " + book.getPublicationYear() + ", Availability: " + book.isAvailable());
        }
    }

    // Display Users
    public void displayUsers() {
        for (user user : users) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail() + ", Phone Number: " + user.getPhoneNumber());
        }
    }

    // Display Borrowing Records
    public void displayBorrowingRecords() {
        for (br record : borrowingRecords) {
            System.out.println("ID: " + record.getId() + ", Book ID: " + record.getBook().getId() + ", Book Title: " + record.getBook().getTitle() + ", User ID: " + record.getUser().getId() + ", User Name: " + record.getUser().getName() + ", Borrow Date: " + record.getBorrowDate() + ", Return Date: " + record.getReturnDate());
        }
    }

    // Main Menu
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Display Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Display Borrowing Records");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Enter Book title: ");
                    scanner.nextLine();
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Book author: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter Book publication year: ");
                    int bookPublicationYear = scanner.nextInt();
                    addBook(new Book(bookId, bookTitle, bookAuthor, bookPublicationYear));
                    break;
                case 2:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter user name: ");
                    scanner.nextLine();
                    String userName = scanner.nextLine();
                    System.out.print("Enter user email: ");
                    String userEmail = scanner.nextLine();
                    System.out.print("Enter user phone number: ");
                    String userPhoneNumber = scanner.nextLine();
                    addUser(new user(userId, userName, userEmail, userPhoneNumber));
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    displayUsers();
                    break;
                case 5:
                    System.out.print("Enter Book ID: ");
                    int borrowBookId = scanner.nextInt();
                    System.out.print("Enter user ID: ");
                    int borrowUserId = scanner.nextInt();
                    for (Book book : Books) {
                        if (book.getId() == borrowBookId) {
                            for (user user : users) {
                                if (user.getId() == borrowUserId) {
                                    borrowBook(book, user);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = scanner.nextInt();
                    System.out.print("Enter user ID: ");
                    int returnUserId = scanner.nextInt();
                    for (Book book : Books) {
                        if (book.getId() == returnBookId) {
                            for (user user : users) {
                                if (user.getId() == returnUserId) {
                                    returnBook(book, user);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 7:
                    displayBorrowingRecords();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 8);
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.mainMenu();
    }
}