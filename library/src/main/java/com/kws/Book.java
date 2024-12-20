package com.kws;

public class Book {
    // 모든 인스턴스에서 공유한다.
    private static int serialNum = 0;
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int year;

    // bookId는 책이 추가될 때마다 1씩 증가
    public Book(String title, String author, String publisher, int year) {
        serialNum++;
        this.bookId = serialNum;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "책번호=" + bookId + ", 제목=" + title + ", 글쓴이=" + author + ", 출판사=" + publisher + ", 출판년도=" + year + "]";
    }
}
