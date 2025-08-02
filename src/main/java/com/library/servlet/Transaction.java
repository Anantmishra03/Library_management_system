package com.library.servlet;

public class Transaction {
    private String studentId;
    private String studentName;
    private String bookId;
    private String bookName;
    private String issueDate;
    private String dueDate;
    private String returnDate;

    public Transaction() {}

    public Transaction(String studentId, String studentName, String bookId, String bookName,
                       String issueDate, String dueDate, String returnDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.bookId = bookId;
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getBookId() { return bookId; }
    public String getBookName() { return bookName; }
    public String getIssueDate() { return issueDate; }
    public String getDueDate() { return dueDate; }
    public String getReturnDate() { return returnDate; }

    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setBookId(String bookId) { this.bookId = bookId; }
    public void setBookName(String bookName) { this.bookName = bookName; }
    public void setIssueDate(String issueDate) { this.issueDate = issueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }
}
