package LibraryManagementSystem;

import LibraryManagementSystem.entities.Book;
import LibraryManagementSystem.entities.Library;
import LibraryManagementSystem.entities.Member;
import LibraryManagementSystem.enums.BookType;
import LibraryManagementSystem.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementMain {

    public static void main(String[] args) {
        
        Book book1 = new Book("1", "History book", "dinesh", BookType.HISTORY);
        Book book2 = new Book("2", "Science book", "sai", BookType.SCIENCE);
        Book book3 = new Book("3", "Fiction book", "kumar", BookType.FICTION);
        Book book4 = new Book("4", "Biography book", "pawan", BookType.BIOGRAPHY);
        Book book5 = new Book("5", "History book 2", "kalyan", BookType.HISTORY);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        Member mem1 = new Member("1", "dinesh");
        Member mem2 = new Member("2", "sai");
        Member mem3 = new Member("3", "kumar");
        Member mem4 = new Member("4", "pawan");
        Member mem5 = new Member("5", "kalyan");

        List<Member> members = new ArrayList<>();
        members.add(mem1);
        members.add(mem2);
        members.add(mem3);
        members.add(mem4);
        members.add(mem5);

        Library library = new Library(books, members);

        LibraryService libraryService = new LibraryService(library);

        
        issueBookSafely(libraryService, "1", "1");
        issueBookSafely(libraryService, "2", "2");
        issueBookSafely(libraryService, "5", "5");


        
        returnBookSafely(libraryService, "1");
        returnBookSafely(libraryService, "3");


    }

    private static void issueBookSafely(LibraryService libraryService, String bookId, String memberId) {
        try {
            libraryService.issueBook(bookId, memberId);
        } catch (IllegalStateException e) {
            System.out.println("  Issue operation failed: " + e.getMessage());
        }
    }

    private static void returnBookSafely(LibraryService libraryService, String bookId) {
        try {
            libraryService.returnBook(bookId);
        } catch (IllegalStateException e) {
            System.out.println("  Return operation failed: " + e.getMessage());
        }
    }
}
