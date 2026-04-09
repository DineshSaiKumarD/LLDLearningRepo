package LibraryManagementSystem.entities;

import LibraryManagementSystem.enums.BookType;
import LibraryManagementSystem.enums.BorrowedStatus;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private BookType bookType;
    private BorrowedStatus borrowedStatus;

    public Book(String bookId, String title, String author, BookType bookType) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.bookType = bookType;
        this.borrowedStatus = BorrowedStatus.AVAILABLE;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookType getBookType() {
        return bookType;
    }

    public boolean isAvailable() {
        return borrowedStatus == BorrowedStatus.AVAILABLE;
    }

    public void borrowBook() {
        if (isAvailable()) {
            borrowedStatus = BorrowedStatus.BORROWED;
        } else {
            throw new IllegalStateException("Book is already borrowed");
        }
    }

    public void returnBook() {
        if (!isAvailable()) {
            borrowedStatus = BorrowedStatus.AVAILABLE;
        } else {
            throw new IllegalStateException("Book is not borrowed");
        }
    }

    public BorrowedStatus getBorrowedStatus() {
        return borrowedStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookType=" + bookType +
                ", status=" + borrowedStatus +
                '}';
    }

}
