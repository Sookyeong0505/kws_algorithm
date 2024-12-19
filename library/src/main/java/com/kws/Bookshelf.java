package com.kws;

public class Bookshelf {
    private int bookId;
    private static Bookshelf instance = new Bookshelf();

    private Bookshelf() {
        bookId = 0;
    }

    public static Bookshelf getInstance() {
        return instance;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
