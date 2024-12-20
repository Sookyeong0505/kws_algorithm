package com.kws;

public class Bookshelf {
    public static final Bookshelf INSTANCE = new Bookshelf();
    private final Book[][] bookshelf = new Book[10][10];

    private Bookshelf() {}

    public static Bookshelf getInstance() {
        return INSTANCE;
    }

    public Book[][] getBookshelf() {
        return bookshelf;
    }

}
