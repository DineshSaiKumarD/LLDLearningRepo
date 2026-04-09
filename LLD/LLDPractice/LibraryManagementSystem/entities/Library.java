package LibraryManagementSystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;
    private List<BorrowRecord> borrowRecords;

    public Library(List<Book> books, List<Member> members) {
        this.books = books;
        this.members = members;
        this.borrowRecords = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

        public void addBook(Book book) {
            books.add(book);
            System.out.println(" Book added: " + book);
        }

        public void addMember(Member member) {
            members.add(member);
            System.out.println(" Member added: ID=" + member.getMemberId() + ", Name=" + member.getName());
        }

        public void removeBook(Book book) {
            books.remove(book);
            System.out.println(" Book removed: " + book);
        }

        public void removeMember(Member member) {
            members.remove(member);
            System.out.println(" Member removed: ID=" + member.getMemberId() + ", Name=" + member.getName());
        }

        public Book findBookByBookId(String bookId) {
            for (Book book : books) {
                if (book.getBookId().equals(bookId))
                    return book;
            }
            return null;
        }

        public boolean validateMember(String memberId) {
            for (Member member : members) {
                if (member.getMemberId().equals(memberId)) {
                    return true;
                }
            }
            return false;
        }

        public void addBorrowRecord(BorrowRecord borrowRecord) {
            borrowRecords.add(borrowRecord);
            System.out.println(" Borrow Record Created: RecordID=" + borrowRecord.getRecordId() + 
                    ", BookID=" + borrowRecord.getBookId() + ", MemberID=" + borrowRecord.getMemberId() + 
                    ", DueDate=" + borrowRecord.getDueDate());
        }

        public List<BorrowRecord> getBorrowRecords() {
            return borrowRecords;
        }


}
