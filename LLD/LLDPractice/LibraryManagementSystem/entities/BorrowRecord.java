package LibraryManagementSystem.entities;

public class BorrowRecord {

    private String recordId;
    private String bookId;
    private String memberId;
    private String borrowDate;
    private String dueDate;
    private String returnDate;

    public BorrowRecord(String recordId, String bookId, String memberId, String borrowDate, String dueDate) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null; // Initially, the return date is null
    }

    public String getRecordId() {
        return recordId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

}


