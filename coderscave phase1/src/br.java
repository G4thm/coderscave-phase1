import java.util.*;
public class br {
    private int id;
    private Book book;
    private user user;
    private Date borrowDate;
    private Date returnDate;

    public br(int id, Book book, user user, Date borrowDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public user getUser() {
        return user;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}