package LibraryManagementSystem.service;

import LibraryManagementSystem.entities.Book;
import LibraryManagementSystem.entities.BorrowRecord;
import LibraryManagementSystem.entities.Library;

import java.time.LocalDate;

public class LibraryService {

    private Library  library;

    public LibraryService(Library library) {
        this.library = library;
        System.out.println(" LibraryService initialized");
    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void removeBook(Book book) {
        library.removeBook(book);
    }

        public void issueBook(String bookId, String memberId) {
            System.out.println(" BookID: " + bookId + ", MemberID: " + memberId);
            
            Book book = library.findBookByBookId(bookId);
            
            if (book == null) {
                System.out.println(" ERROR: Book not found!");
                throw new IllegalStateException("Book not found");
            }
            System.out.println(" Book found: " + book);
            
            if (!library.validateMember(memberId)) {
                System.out.println(" ERROR: Invalid member!");
                throw new IllegalStateException("Invalid member");
            }
            System.out.println(" Member validated!");
            
            if (!book.isAvailable()) {
                System.out.println(" ERROR: Book is not available (already borrowed)!");
                throw new IllegalStateException("Book is not available or member is not valid");
            }
            System.out.println(" Book is available!");
            
            book.borrowBook();
            System.out.println(" Book borrowed successfully!");
            
            BorrowRecord borrowRecord = createBorrowRecord(bookId, memberId);
            library.addBorrowRecord(borrowRecord);
            
            System.out.println(" Book issued successfully!");
        }

        public void returnBook(String bookId) {
            System.out.println(" BookID: " + bookId);
            
            Book book = library.findBookByBookId(bookId);
            
            if (book == null) {
                System.out.println(" ERROR: Book not found!");
                throw new IllegalStateException("Book not found");
            }
            System.out.println(" Book found: " + book);
            
            if (book.isAvailable()) {
                System.out.println(" ERROR: Book is not borrowed (nothing to return)!");
                throw new IllegalStateException("Book is not borrowed");
            }
            System.out.println(" Book is currently borrowed!");
            
            book.returnBook();
            System.out.println(" Book returned successfully!");
        }

    LocalDate calculateDueDate(int borrowDays) {
        return LocalDate.now().plusDays(borrowDays);
    }

    public BorrowRecord createBorrowRecord(String bookId, String memberId) {
        String recordId = "BR" + System.currentTimeMillis();
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = calculateDueDate(14);
        System.out.println(" Creating borrow record - RecordID: " + recordId + ", BorrowDate: " + borrowDate + ", DueDate: " + dueDate);
        return new BorrowRecord(recordId, bookId, memberId, borrowDate.toString(), dueDate.toString());
    }


}
